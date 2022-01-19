$(document).ready(function () {
    // On ready
});


async function iniciarSesion() {

    let datos = {};

    //Los campos deben ser iguales que en su modelo
    datos.email = document.getElementById("txtEmail").value;
    datos.password = document.getElementById("txtPassword").value;

    const request = await fetch('api/login', {
        method: 'POST',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },

        // Agarra cualquier objeto de js y lo convierte a un string de JSON
        body: JSON.stringify(datos)

    });

    const respuesta = await request.text();

    if (respuesta == 'OK'){
        //Redirecciona la pagina
        alert("Correcto logeo")
    }else{
        swal({
            title: "Error!",
            text: "Las credenciales son incorrectas. Por favor intente nuevamente",
            type: "error",
            confirmButtonText : "Volver a intentar",
        });
    }

}

function goToRegister() {
    window.location.href = "register";
}