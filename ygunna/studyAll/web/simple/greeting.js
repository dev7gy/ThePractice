const form = document.querySelector(".js-form"),
    input = form.querySelector("input"),
    greeting = document.querySelector(".js-greeting");

const USER_LOCALSTORAGE = "currentUser",
    SHOWING_CLASSNAME = "showing";

function paintGreeting(text) {
    form.classList.remove(SHOWING_CLASSNAME);
    greeting.classList.add(SHOWING_CLASSNAME);
    greeting.innerText = `Hello ${text}`;
}

function saveName(text){
    localStorage.setItem(USER_LOCALSTORAGE, text);
}

// event -- preventDefault
function handleSubmit(event) {
    console.log(event);
    event.preventDefault();
    const currentValue = input.value;

    paintGreeting(currentValue);
    saveName(currentValue);
}

function askForName() {
    form.classList.add(SHOWING_CLASSNAME);
    form.addEventListener("submit", handleSubmit);
}

function loadName(){
    const currentUser = localStorage.getItem(USER_LOCALSTORAGE);
    if(currentUser === null) {
        askForName();
    } else {
        paintGreeting(currentUser);
    }
}

function init() {
    loadName();
}
init();