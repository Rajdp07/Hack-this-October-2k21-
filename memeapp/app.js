async function getmeme() {
    const url = "https://meme-api.herokuapp.com/gimme"
    const res = await fetch(url)
    const data = await res.json()
    console.log(data)
    
    document.getElementById('mtitle').innerHTML = data.title
    document.getElementById('meme').src = data.url

}