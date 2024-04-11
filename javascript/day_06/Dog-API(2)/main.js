const btn = document.getElementById("btn");
const image = document.getElementById("image");
const select = document.getElementById("breed-list");

async function getBreedList() {
    let res = await axios.get("https://dog.ceo/api/breeds/list/all")

    renderBreed(res.data.message)
}

function renderBreed(breeds) {
    for (const key in breeds) {
        const option = document.createElement("option")
        option.innerText = key
        option.value = key
        select.appendChild(option)
    }
}

getBreedList()

btn.addEventListener("click", async () => {
    const selectedBreed = select.value;
    try {
        const response = await axios.get(`https://dog.ceo/api/breed/${selectedBreed}/images/random`);
        console.log(response.data.message)
        image.src = response.data.message;
    } catch (error) {
        console.log(error);
    }
}) 
