document.addEventListener("DOMContentLoaded", main);
let writeForm, titleInput, contentInput
function main() {
    initElements();
    bindEvents();
}

async function initElements() {
    writeForm = document.getElementById("writeForm");
    titleInput = document.getElementById("title");
    contentInput = document.getElementById("content");
}

async function bindEvents() {
    writeForm.addEventListener("submit", handleWriteForm);
}

async function handleWriteForm(e) {
    e.preventDefault();

    const post = {
        title: titleInput.value,
        content:contentInput.value
    }

    const res = await fetch("/api/postWrite", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(post)
    });
}
