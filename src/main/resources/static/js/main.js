let verclave=document.getElementById("verclave");
let clave=document.getElementById("clave")
let icono=document.getElementById("icono")
let con=true

let iniciaSesion = document.querySelector('.iniciaSesion')
let registrate = document.querySelector('.registrate')
let formulariologin = document.querySelector('.formulariologin')
let formularioregistro = document.querySelector('.formularioregistro')

verclave.addEventListener('click', function(){

if (con==true){
clave.type="text"
icono.classList.add("fa-eye-slash")
con=false
}   else{
clave.type="password"
icono.classList.remove("fa-eye-slash")
con=true
}
});



// $(function(){
//     $("#menu li").on("click", function(){
//         addEventListener("click", alert)
//         var i=$(this.formulariologin());
//         $ ("#formulariologin").hide();
//         $("#formularioregistro").eq(i).show();
//         $("#menu li a").removeClass("active");
//         $(this).find("a").addClass("active");
//     });
// });

// iniciaSesion.addEventListener('click', ()=>{
//     formulariologin.classList.add('active')
//     formularioregistro.classList.remove('active')
// })
// registrate.addEventListener('click', ()=>{
//     console.log('hola estoy probando');
//     formulariologin.classList.remove('active')
//     formularioregistro.classList.add('active')
// })

function hideshow(){
    var frm=document.formulariologin;
    if(frm.style.display=="block"){
        frm.style.display="none"}
    else
    if(frm.style.display=="none"){
        frm.style.display="block"}
    }



$(document).ready(function() {
    $('#example').DataTable();
} );
      