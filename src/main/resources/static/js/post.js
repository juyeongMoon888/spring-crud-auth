document.addEventListener("DOMContentLoaded", main);
let writeBtn;

function main() {
    initElement();
    fetchMainView();
}

async function initElement() {
    writeBtn = document.getElementById("writeBtn");
}

async function fetchMainView() {
    location.href = "/postForm";
}
