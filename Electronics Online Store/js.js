function home(){
    open("home.html","_self");
}
function headset(){
    open("headset.html","_self");
}
function laptop(){
    open("laptop.html","_self");
}
function mouse(){
    open("mouse.html","_self");
}
function pad(){
    open("pad.html","_self");
}
function keyboard(){
    open("keyboard.html","_self");
}
function pc(){
    open("pc.html","_self");
}
function table(c){
    open("table.html","_self");
    x1=document.getElementById('keyboard');
    x2=document.getElementById('pad');
    x3=document.getElementById('headset');
    x4=document.getElementById('pc');
    p1=document.getElementById(c);
}
function done(){
    alert("done");
}
function changeLaptop(c){
    img1 = document.getElementById('blacklap');
    img2 = document.getElementById('whitelap');
    img3 = document.getElementById('bluelap');
    lapimg = document.getElementById('lapimg');

    imgclicked = document.getElementById(c);
    img1.style.opacity = '0.3';
    img2.style.opacity = '0.3';
    img3.style.opacity = '0.3';
    imgclicked.style.opacity = '1';

    lapimg.src = c +'.png'
}
function changeMice(c){
    img1 = document.getElementById('blackM');
    img2 = document.getElementById('whiteM');
    img3 = document.getElementById('pinkM');    
    img4 = document.getElementById('randomM'); 
    Mimg = document.getElementById('Mimg');   
    imgclicked = document.getElementById(c);
    img1.style.opacity = '0.3';
    img2.style.opacity = '0.3';
    img3.style.opacity = '0.3';
    img4.style.opacity = '0.3';
    imgclicked.style.opacity = '1';

    Mimg.src = c +'.png'
}
function changeHeadset(c){
    img1 = document.getElementById('blackH');
    img2 = document.getElementById('whiteH');
    img3 = document.getElementById('pinkH');
    lapimg = document.getElementById('Himg');

    imgclicked = document.getElementById(c);
    img1.style.opacity = '0.3';
    img2.style.opacity = '0.3';
    img3.style.opacity = '0.3';
    imgclicked.style.opacity = '1';

    Himg.src = c +'.png'
}
function changePad(c){
    img1 = document.getElementById('blackP');
    img2 = document.getElementById('whiteP');
    img3 = document.getElementById('pinkP');
    lapimg = document.getElementById('Pimg');

    imgclicked = document.getElementById(c);
    img1.style.opacity = '0.3';
    img2.style.opacity = '0.3';
    img3.style.opacity = '0.3';
    imgclicked.style.opacity = '1';

    Pimg.src = c +'.png'
}
function changeKeyboard(c){
    img1 = document.getElementById('rgbK');
    img2 = document.getElementById('greenK');
    lapimg = document.getElementById('Kimg');

    imgclicked = document.getElementById(c);
    img1.style.opacity = '0.3';
    img2.style.opacity = '0.3';
    imgclicked.style.opacity = '1';

    Kimg.src = c +'.png'
}
function changePC(c){
    img1 = document.getElementById('blackPC');
    img2 = document.getElementById('whitePC');
    lapimg = document.getElementById('PCimg');

    imgclicked = document.getElementById(c);
    img1.style.opacity = '0.3';
    img2.style.opacity = '0.3';
    imgclicked.style.opacity = '1';

    PCimg.src = c +'.png'
}