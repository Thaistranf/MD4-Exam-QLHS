function addStudent(){
    axios.post("http://localhost:8081/students", {
        id: document.getElementById("id").value,
        name: document.getElementById("name").value,
        email: document.getElementById("email").value,
        dateOfBirth: document.getElementById("dateOfBirth").value,
        address: document.getElementById("address").value,
        phone: document.getElementById("phone").value,
        classroom: {
            id: document.getElementById("classroom").value
        }
    }).then(() => {
        $('#addNewStudent').modal('hide');
        showListStudent();
    })
}