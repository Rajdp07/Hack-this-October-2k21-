let string = "";
let codeString = "";
var sha;
let maxlength = 50;

document.querySelectorAll(".image").forEach((element, index) => {
     element.addEventListener("click", (event) => {
          if (string.length < maxlength) {
               let hash = CryptoJS.MD5(
                    CryptoJS.enc.Latin1.parse(event.target.src)
               ).toString();
               if (string.length == 39) {
                    sha = CryptoJS.SHA256(hash).toString().slice(-11);
               } else {
                    sha = CryptoJS.SHA256(hash).toString().slice(-13);
               }
               codeString += sha;

               let appendCode = document.createElement("p");
               appendCode.innerHTML = codeString;
               document.querySelector(".code1").appendChild(appendCode);

               let image = document.createElement("img");
               image.src = element.src;
               document.querySelector(".code-img").appendChild(image);

               string += codeString;
          }
          codeString = "";
     });
});

//Reset Button
document.querySelector(".btn").addEventListener("click", (event) => {
     window.location.reload();
});
