showListStudent()
function showListStudent(){
    axios.get("http://localhost:8081/students").then(res => {
        let listStudent = res.data
        console.log(listStudent)
        axios.get("http://localhost:8081/classrooms").then(res => {
            let listClassroom = res.data
            let str = `
            <button type="button" class="btn btn-success" data-bs-toggle="modal" data-bs-target="#addNewStudent">Add new student</button>
            <table class="table">
              <thead>
                <tr>
                  <th scope="col">#</th>
                  <th scope="col">Name</th>
                  <th scope="col">DateOfBirth</th>
                  <th scope="col">Email</th>
                  <th scope="col">Address</th>
                  <th scope="col">Phone</th>
                  <th scope="col">Classroom</th>
                  <th scope="col" colspan="2">Action</th>
                </tr>
              </thead>
              <tbody>`
                for (let i = 0; i < listStudent.length; i++) {
                    str += `
                    <tr>
                      <td>${listStudent[i].id}</td>
                      <td>${listStudent[i].name}</td>
                      <td>${listStudent[i].dateOfBirth}</td>
                      <td>${listStudent[i].email}</td>
                      <td>${listStudent[i].address}</td>
                      <td>${listStudent[i].phone}</td>
                      <td>${listStudent[i].classroom.className}</td>
                      <td><button type="button" class="btn btn-warning">Edit</button></td>
                      <td><button type="button" class="btn btn-danger">Delete</button></td>
                    </tr>`
                }
            str += `</tbody>
            </table>`
            document.getElementById("body").innerHTML = str;

                str += `
            <!-- Modal add new student -->
            <div class="modal fade" id="addNewStudent" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
              <div class="modal-dialog">
                <div class="modal-content">
                  <div class="modal-header">
                    <h1 class="modal-title fs-5" id="staticBackdropLabel">Create new student</h1>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                  </div>
                  <div class="modal-body">
                      <input type="hidden" class="form-control" id="id" aria-describedby="emailHelp"> 
                      <div class="mb-3">
                        <label class="form-label">Name</label>
                        <input type="text" class="form-control" id="name" aria-describedby="emailHelp" placeholder="Enter name">   
                      </div>
                      <div class="mb-3">
                        <label class="form-label">Email address</label>
                        <input type="email" class="form-control" id="email" aria-describedby="emailHelp" placeholder="Enter email">   
                      </div>
                      <div class="mb-3">
                        <label class="form-label">Date of Birth</label>
                        <input type="date" class="form-control" id="dateOfBirth" aria-describedby="emailHelp">   
                      </div>
                      <div class="mb-3">
                        <label class="form-label">Address</label>
                        <input type="text" class="form-control" id="address" aria-describedby="emailHelp" placeholder="Enter address">   
                      </div>
                      <div class="mb-3">
                        <label class="form-label">Phone Number</label>
                        <input type="text" class="form-control" id="phone" aria-describedby="emailHelp" placeholder="Enter phone number">   
                      </div>
                      <div class="mb-3">
                        <label class="form-label">Class</label>
                            <select class="form-control" id="classroom">
                            <option selected>Open this select menu</option>`

            for (let i = 0; i < listClassroom.length; i++) {
                str += `
                <option value="${listClassroom[i].id}">${listClassroom[i].className}</option>`
            }
                            str += `</select>  
                      </div>
                  </div>
                  <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                    <button type="button" class="btn btn-primary" onclick="addStudent()">Submit</button>
                  </div>
                </div>
              </div>
            </div>`
            document.getElementById("body").innerHTML = str;
        })
    })
}