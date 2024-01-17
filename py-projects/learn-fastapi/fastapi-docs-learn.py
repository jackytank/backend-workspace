from enum import Enum
from typing import Optional, Annotated

from fastapi import FastAPI, Query, Path, Body
from pydantic import BaseModel, Field

app = FastAPI()


@app.get("/")
async def root():
    return {"message": "Hello World"}


class ShitModel(BaseModel):
    name: str
    description: str | None = Field(
        default=None, title="The Description of the item", max_length=300
    )
    price: float = Field(gt=0, description="The price must be greater than zero")
    tax: float | None = None


@app.put("/shits/{shit_id}")
async def update_shit(shit_id: int, item: Annotated[ShitModel, Body(embed=True)]):
    results = {"shit_id": shit_id, "item": item}
    return results


@app.get("/shits/{shit_id}")
async def read_shits(
        shit_id: Annotated[int, Path(
            title="The ID of the shit to get",
            ge=1,
            le=10
        )],
        q: Annotated[
            str | None,
            Query(
                min_length=3,
                max_length=50,
                pattern="^fixedquery$",
                alias="item-query",
                deprecated=True,
            )
        ] = None,
        x: Annotated[
            list[str],
            Query(
                title="Query List String",
                description="Query List String Desc",
                min_length=2,
                max_length=5,
            )
        ] = ['foo', 'bar'],
        hidden_query: Annotated[
            str | None,
            Query(include_in_schema=False)
        ] = None,
        importance: Annotated[int, Body(embed=True)] = 2
):
    results = {"shits": [{"item_id": "Foo"}, {"item_id": "Bar"}]}
    if q or x or shit_id or importance:
        results.update({"q": q, "x": x, "shit_id": shit_id, "importance": importance})
    if hidden_query:
        results.update({"hidden_query": hidden_query})
    else:
        results.update({"hidden_query": "No hidden query"})
    return results


class CreateItem(BaseModel):
    name: str
    description: str | None = None
    price: float
    tax: float | None = None


@app.put("/items/{item_id}")
async def update_item(item_id: int, item: CreateItem, q: str | None = None):
    result = {"item_id": item_id, **item.model_dump()}
    if q:
        result.update({"q": q})
    return result


@app.post("/items/")
async def create_item(item: CreateItem):
    item_dict = item.dict()
    if item.tax:
        price_with_tax = item.price + item.tax
        item_dict.update({"price_with_tax": price_with_tax})
    return item_dict


@app.get("/users/{user_id}/items/{item_id}")
async def read_user_item(
        user_id: int,
        item_id: str,
        q: str | None = None,
        short: bool = False
):
    item = {"item_id": item_id, "owner_id": user_id}
    if q:
        item.update({"q": q})
    if not short:
        item.update({"description": "This is an amazing item that has a long description"})
    return item


fake_items_db = [{"item_name": "Foo"}, {"item_name": "Bar"}, {"item_name": "Baz"}]


@app.get("/items/")
async def search_items(skip: int = 0, limit: int = 10):
    return fake_items_db[skip: skip + limit]


@app.get("/files/{file_path:path}")
async def read_file(file_path: str):
    return {"file_path": file_path}


class ModelName(str, Enum):
    alexnet = "alexnet"
    resnet = "resnet"
    lenet = "lenet"


@app.get("/models/{model_name}")
async def get_model(model_name: ModelName):
    if model_name is ModelName.alexnet:
        return {"model_name": model_name, "message": "Deep Learning FTW!"}
    if model_name.value == "lenet":
        return {"model_name": model_name, "message": "LeCNN all the images"}
    return {"model_name": model_name, "message": "Have some residuals"}


@app.get("/items/default")
async def default_read_item():
    return {"item_id": "Default"}


@app.get("/items/{item_id}")
async def read_item(item_id: str, q: str | None = None, short: bool = False):
    item = {"item_id": item_id}
    if q:
        item.update({"q": q})
    if not short:
        item.update({"description": "This is an amazing item that has a long description"})
    return item


weird_students = {
    1: {"name": "John", "age": 17, "year": "year 12"},
    2: {"name": "Mary", "age": 16, "year": "year 11"},
    3: {"name": "Bob", "age": 16, "year": "year 11"},
}


class WeirdStudent(BaseModel):
    name: str
    age: int
    year: str


class UpdateWeirdStudent(BaseModel):
    name: Optional[str] = None
    age: Optional[int] = None
    year: Optional[str] = None


@app.get("/get-student/{student_id}")
def get_student(student_id: int):
    return weird_students[student_id]


@app.get("/get-by-name/{student_id}")
def get_student_by_name(*, student_id: int, name: Optional[str] = None, test: int = 0):
    for student_id in weird_students:
        if weird_students[student_id]["name"] == name:
            return weird_students[student_id]
    return {"Data": "Not found"}


@app.post("/create-student/{student_id}")
def create_student(student_id: int, student: WeirdStudent):
    if student_id in weird_students:
        return {"Error": "Student exists"}
    weird_students[student_id] = student
    return weird_students[student_id]


@app.put("/update-student/{student_id}")
def update_student(student_id: int, student: UpdateWeirdStudent):
    if student_id not in weird_students:
        return {"Error": "Student does not exist"}
    if student.name is not None:
        weird_students[student_id].name = student.name
    if student.age is not None:
        weird_students[student_id].age = student.age
    if student.year is not None:
        weird_students[student_id].year = student.year
    weird_students[student_id] = student
    return weird_students[student_id]


@app.delete("/delete-student/{student_id}")
def delete_student(student_id: int):
    if student_id not in weird_students:
        return {"Error": "Student does not exist"}
    del weird_students[student_id]
