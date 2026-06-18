const API_URL =
"http://localhost:8080/certificateservice";

window.onload = loadCertificates;

function loadCertificates(){
    fetch(API_URL)
    .then(res => res.json())
    .then(data => {
        let table = document.getElementById("certificateTable");
        table.innerHTML = "";

        data.forEach(c => {
            table.innerHTML += `
                <tr>
                    <td>${c.c_id}</td>
                    <td>${c.c_name}</td>
                    <td>${c.issuedBy}</td>
                    <td>${c.course}</td>
                    <td>${c.studentName}</td>
                    <td>
                        <button class="edit-btn" onclick="editCertificate(${c.c_id})">Edit</button>
                        <button class="delete-btn" onclick="deleteCertificate(${c.c_id})">Delete</button>
                    </td>
                </tr>
            `;
        });
    })
    .catch(error => console.log("Error:", error));
}
function addCertificate(){

    const certificate = {

        c_id: document.getElementById("c_id").value,

        c_name: document.getElementById("c_name").value,

        issuedBy: document.getElementById("issuedBy").value,

        issueDate: document.getElementById("issueDate").value,

        expiryDate: document.getElementById("expiryDate").value,

        course: document.getElementById("course").value,

        studentName:
        document.getElementById("studentName").value
    };

    fetch(API_URL,{

        method:"POST",

        headers:{
            "Content-Type":"application/json"
        },

        body:JSON.stringify(certificate)

    })

    .then(() => {

        alert("Certificate Added");

        clearForm();

        loadCertificates();
    });
}

function getCertificateById(){

    let id =
    document.getElementById("searchId").value;

    fetch(`${API_URL}/${id}`)

    .then(response => response.json())

    .then(certificate => {

        let table =
        document.getElementById("certificateTable");

        table.innerHTML = `

        <tr>

        <td>${certificate.c_id}</td>

        <td>${certificate.c_name}</td>

        <td>${certificate.issuedBy}</td>

        <td>${certificate.course}</td>

        <td>${certificate.studentName}</td>

        <td>

        <button class="edit-btn"
        onclick="editCertificate(${certificate.c_id})">
        Edit
        </button>

        <button class="delete-btn"
        onclick="deleteCertificate(${certificate.c_id})">
        Delete
        </button>

        </td>

        </tr>
        `;
    });
}

function editCertificate(id){

    fetch(`${API_URL}/${id}`)

    .then(response => response.json())

    .then(data => {

        document.getElementById("c_id").value =
        data.c_id;

        document.getElementById("c_name").value =
        data.c_name;

        document.getElementById("issuedBy").value =
        data.issuedBy;

        document.getElementById("issueDate").value =
        data.issueDate;

        document.getElementById("expiryDate").value =
        data.expiryDate;

        document.getElementById("course").value =
        data.course;

        document.getElementById("studentName").value =
        data.studentName;
    });
}

function updateCertificate(){

    let id =
    document.getElementById("c_id").value;

    const certificate = {

        c_id:id,

        c_name:document.getElementById("c_name").value,

        issuedBy:document.getElementById("issuedBy").value,

        issueDate:document.getElementById("issueDate").value,

        expiryDate:document.getElementById("expiryDate").value,

        course:document.getElementById("course").value,

        studentName:
        document.getElementById("studentName").value
    };

    fetch(`${API_URL}/${id}`,{

        method:"PUT",

        headers:{
            "Content-Type":"application/json"
        },

        body:JSON.stringify(certificate)

    })

    .then(() => {

        alert("Certificate Updated");

        clearForm();

        loadCertificates();
    });
}

function deleteCertificate(id){

    if(confirm("Delete this certificate?")){

        fetch(`${API_URL}/${id}`,{

            method:"DELETE"
        })

        .then(() => {

            alert("Certificate Deleted");

            loadCertificates();
        });
    }
}

function clearForm(){

    document.getElementById("c_id").value="";
    document.getElementById("c_name").value="";
    document.getElementById("issuedBy").value="";
    document.getElementById("issueDate").value="";
    document.getElementById("expiryDate").value="";
    document.getElementById("course").value="";
    document.getElementById("studentName").value="";
}