from fastapi import FastAPI

app = FastAPI()

students = {
    1: {
        "name": "John",
        "age": 17,
        "year": "year 12"
    },
    2: {
        "name": "Mary",
        "age": 16,
        "year": "year 11"
    },
    3: {
        "name": "Bob",
        "age": 16,
        "year": "year 11"
    }
}


@app.get("/")
def index():
    return {"name": "First data"}


@app.get("/get-student/{student_id}")
def get_student(student_id: int):
    return students[student_id]
