$(document).ready(function () {
    // On ready
});


async function registrarUsuario() {

    let datos = {};

    //Los campos deben ser iguales que en su modelo
    datos.nombre = document.getElementById("txtNombre").value;
    datos.email = document.getElementById("txtEmail").value;
    datos.telefono = document.getElementById("txtTelefono").value;
    datos.password = document.getElementById("txtPassword").value;

    let repetirPassword = document.getElementById("txtRepetirPassword").value;

    if (repetirPassword != datos.password) {
        swal({
            title: "Ha ocurrido un error!",
            text: "La contraseña que escribiste es diferente.",
            type: "warning",
            confirmButtonText : "Aceptar",
        }).then(function (){
            return;
        })
    }

    const request = await fetch('api/usuarios', {
        method: 'POST',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },

        // Agarra cualquier objeto de js y lo convierte a un string de JSON
        body: JSON.stringify(datos)

    });

    const respuesta = await request.text();

    if (respuesta == 'OK') {

        swal({
            title: "Exito!",
            text: "Se ha registrado correctamente",
            type: "success",
            confirmButtonText : "Aceptar",
        })
        .then(function () {
            window.location.href = "login";
        });

    } else if (respuesta == 'FAIL'){
        swal({
            // Usar una lista de viñetas
            title: "No se podido registrar correctamente",
            html:
                "<ul>\n"
                + "<li>Intente usando otro correo electrónico.</li>\n"
                + "<li>Su nombre debe contener al menos <b>4</b> y máximo <b>30</b> carácteres alfanúmericos.</li>\n"
                + "<li>Su número telefónico debe ser bajo el formato 3xxxxxxxxx.</li>\n"
                + "<li>La contraseña debe contener al menos <b>8</b> y máximo <b>20</b> carácteres alfanúmericos.</li>\n"
                + "</ul>",
            type: "error",
            confirmButtonText : "Volver a intentar",
        });
    }

}

function goToLogin() {
    window.location.href = "login";
}