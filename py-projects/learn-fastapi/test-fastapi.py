from typing import Optional
from fastapi import FastAPI
from pydantic import BaseModel

app = FastAPI()

students = {
    1: {"name": "John", "age": 17, "year": "year 12"},
    2: {"name": "Mary", "age": 16, "year": "year 11"},
    3: {"name": "Bob", "age": 16, "year": "year 11"},
}


class Student(BaseModel):
    name: str
    age: int
    year: str


@app.get("/")
def index():
    return {"name": "First data"}


@app.get("/get-student/{student_id}")
def get_student(student_id: int):
    return students[student_id]


@app.get("/get-by-name/{student_id}")
def get_student_by_name(*, student_id: int, name: Optional[str] = None, test: int = 0):
    for student_id in students:
        if students[student_id]["name"] == name:
            return students[student_id]
    return {"Data": "Not found"}


@app.post("/create-student/{student_id}")
def create_student(student_id: int, student: Student):
    if student_id in students:
        return {"Error": "Student exists"}
    students[student_id] = student
    return students[student_id]