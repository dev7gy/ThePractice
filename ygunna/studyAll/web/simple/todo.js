const toDoForm = document.querySelector(".js-toDoForm"),
 toDoInput = toDoForm.querySelector("input"),
 toDoList = document.querySelector(".js-toDoList");

const TODO_LOCAL_STORAGE = 'toDoList'

let toDoArray = [];

function delToDo(event) {
    // find parent
    // console.dir(event.target)

    const btn = event.target;
    const li = btn.parentNode;
    toDoList.removeChild(li);
    const cleanToDoArray = toDoArray.filter(function(toDo) {
        console.log(toDo);
        return toDo.id !== parseInt(li.id);
    });

    toDoArray = cleanToDoArray;
    saveToDoList();
}

function saveToDoList() {
    // local storage can save only String
    localStorage.setItem(TODO_LOCAL_STORAGE, JSON.stringify(toDoArray));
}

function paintToDo(text) {
    const toDoLi = document.createElement("li");
    const toDoDelBtn = document.createElement("button");
    const toDoSpan = document.createElement("spac");
    const newToDoId = toDoArray.length +1;

    toDoDelBtn.innerText = "X";
    toDoDelBtn.addEventListener("click", delToDo);
    toDoSpan.innerText = text;

    toDoLi.appendChild(toDoSpan);
    toDoLi.appendChild(toDoDelBtn);
    toDoLi.id = newToDoId;

    toDoList.appendChild(toDoLi);
    const toDoObj = {
        text: text,
        id: newToDoId
    };

    toDoArray.push(toDoObj);
    saveToDoList();
}

function loadToDoList() {
    const loadedToDolist = localStorage.getItem(TODO_LOCAL_STORAGE);
    if(loadedToDolist !== null){
        const parsedToDoList = JSON.parse(loadedToDolist);
        parsedToDoList.forEach(function(toDo) {
            paintToDo(toDo.text);
        });
    }
}

function handleSubmit(event) {
    event.preventDefault();
    const currentValue = toDoInput.value;
    paintToDo(currentValue);
    toDoInput.value = "";
}

 function init() {
     loadToDoList();
     toDoForm.addEventListener("submit", handleSubmit)
 }

 init();