const btn = document.getElementById("btn");
const image = document.getElementById("image");
const select = document.getElementById("breed-list");
const ul = document.querySelector("ul");
const result = document.querySelector(".result");

const getBreedList = async () => {
    const res = await axios.get("https://dog.ceo/api/breeds/list/all");
    renderBreed(res.data.message);
}

const renderBreed = (breedsList) => {
    for (const key in breedsList) {
        const option = document.createElement("option");
        option.innerText = key;
        option.value = key;
        select.appendChild(option);
    }
}

getBreedList();


btn.addEventListener("click", async () => {
    const response = await axios.get(`https://dog.ceo/api/breed/${select.value}/list`);
    renderSubList(response.data.message);
}) 

const renderSubList = (subBreedsList) => {
    ul.innerHTML = ""; 

    if (subBreedsList.length == 0) {
        const li = document.createElement("li");
        li.innerText = "Không có sub breed";
        ul.appendChild(li);
    } else {
        subBreedsList.forEach(subBreed => {
            const li = document.createElement("li");
            const a = document.createElement("a");
            a.href = "#";
            a.innerText = subBreed;
            li.appendChild(a);
            ul.appendChild(li);
        });
    }
    renderImage();
}

const renderImage = ()=>{
    const a = document.querySelectorAll("a");

    Array.from(a).forEach(a => {
        a.addEventListener("click", async () => {
            try{
                const res = await axios.get(`https://dog.ceo/api/breed/${select.value}/${a.innerText}/images/random`);
                image.src = res.data.message;
                result.classList.remove("hide");
            }catch(err){
               console.log(err);
            }
        })
    })
}




