const pathURL = (location.pathname).substring(1);
const cdResidencia = pathURL.split("/")[2];
$.ajax({
    url : "../obterResidencias/"+cdResidencia,
    dataType: 'application/json',
    type: 'POST',
    dataType : 'json',
    success : function(response) {
        console.log(response);
    },
    error : function(response) {
        console.log("Access Fail "+ response);
    }
})