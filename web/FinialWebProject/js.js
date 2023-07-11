function home(){
    open("index.html","_self");
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
function about(){
    open("about.html","_self");
}
function linkdn(){
    open("http://www.linkdn.com","_self");
}
function youtube(){
    open("http://www.youtube.com","_self");
}
function watsapp(){
    open("http://www.wattsapp.com","_self");
}
function twitter(){
    open("http://www.twitter.com","_self");
}
function facebook(){
    open("http://www.facebook.com","_self");
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
function buy(productIMG,which){
    num = document.getElementById("select").value;
    price = document.getElementById("price").innerHTML;
    imgsrc = document.getElementById(productIMG).src;
    imgwidth = document.getElementById(productIMG).clientWidth;  

    sessionStorage.setItem("num",num);
    sessionStorage.setItem("price",price);
    sessionStorage.setItem("imgsrc",imgsrc);
    sessionStorage.setItem("which",which);
    open('tabletest.html','_self');
}
function finial(){
    NOP = document.getElementById('NOP');
    NOP.innerHTML = parseInt(sessionStorage.getItem("num"));

    PPP = document.getElementById('PPP'); 
    PPP.innerHTML = parseInt(sessionStorage.getItem("price"));

    Taxes = document.getElementById('Taxes'); 
    Taxes.innerHTML = parseInt(parseInt(sessionStorage.getItem("num"))*(0.05*parseInt(sessionStorage.getItem("price"))));

    total = document.getElementById("Tota");
    total.innerHTML = parseInt(NOP.innerHTML) * parseInt(PPP.innerHTML) + parseInt(Taxes.innerHTML);

    img = document.getElementById('finialproduct');
    img.src = sessionStorage.getItem('imgsrc');

    which = sessionStorage.getItem('which');
    if(which == 'mice'){
        img.style.width = 55 +'%'
        img.style.marginLeft = 23 + '%'
    }
    else if(which == 'pad'){
        img.style.width = 110 +'%'
        img.style.marginLeft = -4 + '%' 
    }
    else if(which == 'keyboard'){
        img.style.width = 110 +'%'
        img.style.marginLeft = -4 + '%'
    }
    else if(which == 'headset'){
        img.style.width = 200 +'%'
        img.style.marginLeft = -40 + '%'    
        img.style.marginTop = -5 + '%'    
    }
    else if(which == 'pc'){
        img.style.width = 55 +'%'
        img.style.marginLeft = 23 + '%'
    }
    else if(which == 'laptop'){
        img.style.width = 100 +'%'
        img.style.marginLeft = 0 +'%' 
    }
}


function time(){
    var d = new Date();
    document.getElementById("year").innerHTML = d.getFullYear() + "/" +d.getMonth() + "/" +d.getDate();
    document.getElementById("t").innerHTML = d.getHours() + "  :  " + d.getMinutes()+ "  :  " + d.getSeconds();   
    setTimeout(time, 1000); 
}
