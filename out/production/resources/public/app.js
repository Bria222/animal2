$(document).ready(function(){
// Animations init
new WOW().init();

var typed=new Typed(`#type`,{
     strings:[" Wildlife Tracker "," An application that allows Rangers to track wildlife sightings in the area. "],
     backSpeed:70,
     typeSpeed:80,
     smartBackspace:true,
     loop: true,
   })
   var typed =new Typed(`#msg`,{
        strings:[" Your Animal has been saved ! "],
        backSpeed:70,
        typeSpeed:80,
        smartBackspace:true,
      })
})


function secondClick(){
timer:4000
Swal.fire(
  'View Animals?',
)
}

function firstClick(){
timer:4000
Swal.fire(
  'Add endangered?',

)
}
function thirdClick(){
timer:4000
Swal.fire(
  'Add Sighting?',

)
}







// Animations init
new WOW().init();