let string = "";
let codeString = "";
var sha;
let maxlength = 50;


document.querySelectorAll('.image').forEach((element, index) => {
     element.addEventListener('click', (event) => {


          if (string.length < maxlength) {

               // const base64String = getBase64Image(event.target);

               // console.log(base64String);

               let hash = CryptoJS.MD5(CryptoJS.enc.Latin1.parse(event.target.src)).toString();

               if (string.length == 39) {

                    sha = CryptoJS.SHA256(hash).toString().slice(-11);

               } else {
                    sha = CryptoJS.SHA256(hash).toString().slice(-13);

               }

               codeString += sha;

               let appendCode = document.createElement('p');
               appendCode.innerHTML = codeString;
               document.querySelector('.code1').appendChild(appendCode);


               let image = document.createElement('img');
               image.src = element.src;
               document.querySelector('.code-img').appendChild(image);

               string += codeString;
          }
          codeString = "";
     })
})



// function getBase64Image(img) {

//      // Create an empty canvas element
//      var canvas = document.createElement("canvas");

//      canvas.width = img.width;
//      canvas.height = img.height;

//      canvas.setAttribute('src', img.id);

//      var dataURL = canvas.toDataURL();

//      return dataURL.replace(/^data:image\/(png|jpg);base64,/, "");
// }


//Reset Button
document.querySelector('.btn').addEventListener('click', (event) => {
     window.location.reload();
})
