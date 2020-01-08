function getDept(d_id){
    let dept = '';
if(d_id == 1){
dept = 'Sales';}
else if(d_id == 2){
dept = 'Accounting';}
else if(d_id == 3){
dept = 'HR';}
else if(d_id == 4){
dept = 'Warehouse';}
else{
dept = 'Corporate'
}
return dept;
}



function getReportsTo(reports_to){
    let rep = ''
if(reports_to == 1){
    rep = 'Jim';
}
if(reports_to == 3){
    rep = 'Michael';
}
if(reports_to == 4){
    rep = 'Oscar';
}
if(reports_to == 5){
    rep = 'Angela';
}
if(reports_to == 7){
    rep = 'Toby';
}
if(reports_to == 8){
    rep = 'Kelly';
}
if(reports_to == 10){
    rep = 'Darryl';
}
if(reports_to == 11){
    rep = 'Lonny';
}
if(reports_to == 13){
    rep = 'Jan';
}
if(reports_to == 14){
    rep = 'David Wallace';
}
if(reports_to == 99){
    rep = 'Reimbursement request approved!';

}
return rep;
}

function display(divID) {
    var x = document.getElementById(divID);
    if (x.style.display === "none") {
      x.style.display = "block";
    } else {
      x.style.display = "none";
    }
  }

function addMsg() {

	let r_id = document.getElementById("r_id5").value;
    let u_id = document.getElementById("u_id5").value;
    let message = document.getElementById("message5").value;
	
    
    
    let xhttp = new XMLHttpRequest();

    xhttp.onreadystatechange = function () {
        if(this.readyState == 4 && this.status == 200) {
            
            
            
        }
    }

    
    xhttp.open("POST", "http://localhost:8080/Project1/addMsg.do", true);
    
    xhttp.setRequestHeader('X-Requested-With', 'XMLHttpRequest');
    xhttp.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
    
    
    xhttp.send("r_id="+r_id+"&u_id="+u_id+"&message="+message);

}


function addReimb() {

	
    let u_id = document.getElementById("u_id").value;
    let g_id = document.getElementById("g_id").value;
    let e_id = document.getElementById("e_id").value;
    let r_date = Number(document.getElementById("date").value);
    let r_time = Number(document.getElementById("time").value);
    let r_address = document.getElementById("address").value;
    let r_cost = Number(document.getElementById("cost").value);
    let r_desc = document.getElementById("desc").value;
    let cutoff = Number(document.getElementById("cutoff").value);  
	let justify = document.getElementById("justify").value;
	
    
    
    let xhttp = new XMLHttpRequest();

    xhttp.onreadystatechange = function () {
        if(this.readyState == 4 && this.status == 200) {
            
			console.log(this.responseText);
        }
    }

    
    xhttp.open("POST", "http://localhost:8080/Project1/addReimb.do", true);
    
    xhttp.setRequestHeader('X-Requested-With', 'XMLHttpRequest');
    xhttp.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
    
    
    xhttp.send("u_id="+u_id+"&g_id="+g_id+"&e_id="+e_id+"&r_date="+r_date+"&r_time="+r_time+"&r_address="+r_address+"&r_cost="+r_cost+"&r_desc="+r_desc+"&cutoff="+cutoff+"&justify="+justify);
    
}

function alterReimb() {
		
    let r_id = document.getElementById("alterreimb").value;
    console.log(r_id);
    let new_reimb = document.getElementById("alteramount").value;
    console.log(new_reimb);
    
    let xhttp = new XMLHttpRequest();
    
    xhttp.onreadystatechange = function() {
        
        if(this.readyState == 4 && this.status == 200) {
            
            console.log(this.responseText);
            
            
            
            
                                 
            
            
            

            
        }
    }
    
    xhttp.open("GET", "http://localhost:8080/Project1/alterReimb.do?r_id=" + r_id + "&new_reimb=" + new_reimb, true);
    
    xhttp.send();
}

function approveReimb() {
		
    let pid = document.getElementById("approvereimb").value;
    console.log(pid);
    
    let xhttp = new XMLHttpRequest();
    
    xhttp.onreadystatechange = function() {
        
        if(this.readyState == 4 && this.status == 200) {
            
            console.log(this.responseText);
            
            
            
            
                                 
            
            
            

            
        }
    }
    
    xhttp.open("GET", "http://localhost:8080/Project1/approveReimb.do?r_id=" + pid, true);
    
    xhttp.send();
}

function delReimb() {
		
    let r_id = document.getElementById("rid").value;
    console.log(r_id);
    
    
    let xhttp = new XMLHttpRequest();
    
    xhttp.onreadystatechange = function() {
        
        if(this.readyState == 4 && this.status == 200) {
            
            console.log(this.responseText);
            
            
            
            
                                 
            
            document.getElementById("r_id").innerHTML = this.responseText;
            

            
        }
    }
    
    xhttp.open("GET", "http://localhost:8080/Project1/delReimb.do?r_id=" + r_id, true);
    
    xhttp.send();
}

function getEvent() {
		
    let rid = document.getElementById("rid").value;
    console.log(rid);
    
    let xhttp = new XMLHttpRequest();
    
    xhttp.onreadystatechange = function() {
        
        if(this.readyState == 4 && this.status == 200) {
            
            console.log(this.responseText);
            
            let eventModel = JSON.parse(this.responseText);
            
            let id = `<h3>Event ID: ${eventModel.e_id}</h3>
                      <h3>Coverage: ${eventModel.coverage}%</h3>`
                                 
            
            document.getElementById("event").innerHTML = id;
            

            
        }
    }
    
    xhttp.open("GET", "http://localhost:8080/Project1/getEvent.do?r_id=" + rid, true);
    
    xhttp.send();
}

function getEventCount() {
		
    // let rid = document.getElementById("rid").value;
    // console.log(rid);
    
    let xhttp = new XMLHttpRequest();
    
    xhttp.onreadystatechange = function() {
        
        if(this.readyState == 4 && this.status == 200) {
            
            console.log(this.responseText);
            
            let eventModel = JSON.parse(this.responseText);
            console.log(eventModel);
            let id = `<h3>Event ID: ${eventModel.e_id}</h3>
                      <h3>Total approved reimbursements of this type: ${eventModel.coverage}</h3>`
                                 
                      function parseJSONrequests(val) {
                      let blocks = '-----------------------------------';
                      console.log(val.length);
                      for (let i = 0; i < val.length; i++){
                          console.log('parsing json');
                          
                          blocks += `<br> Event ID: ${val[i].e_id} <br>
                          Total approved: ${val[i].coverage} <br> 
                          -----------------------------------
                          <br> `;
                      }
                      
                      console.log(blocks);
                      document.getElementById("eventcount").innerHTML = blocks;
                  }
                  parseJSONrequests(eventModel);
            

            
        }
    }
    
    xhttp.open("GET", "http://localhost:8080/Project1/getEventCount.do", true);
    
    xhttp.send();
}

function getMsg() {
		
    let pid = document.getElementById("viewmsg").value;
    console.log(pid);
    
    let xhttp = new XMLHttpRequest();
    
    xhttp.onreadystatechange = function() {
        
        if(this.readyState == 4 && this.status == 200) {
            
            console.log(this.responseText);
            // MsgModel = JSON.parse(this.responseText);
            // function parseJSONrequests(val) {              
                
            //     let blocks = '-----------------------------------';
            //    console.log(val.length);
            //    for (let i = 0; i < val.length; i++){
                   
                   
            //        blocks += 
            //        `<br>Reimb ID: ${reimbModel[i].r_id} <br> 
            //        User ID: ${reimbModel[i].u_id} <br>
            //        Grading ID: ${reimbModel[i].g_id} <br>
            //        Event ID: ${reimbModel[i].e_id} <br>
            //        Date (weeks out): ${reimbModel[i].r_date} <br>
            //        Time: ${reimbModel[i].r_time} <br>
            //        Address: ${reimbModel[i].r_address}<br>
            //        Cost: $${reimbModel[i].r_cost} <br>
            //        Passing grade: ${reimbModel[i].cutoff}% <br>
            //        Current User: ${reimbModel[i].curr_user} <br>
            //        Description: ${reimbModel[i].r_desc} <br>
            //        -----------------------------------
            //        <br> `;
            //    }
            
        }document.getElementById("showmsg").innerHTML =this.responseText;
    }
    
    xhttp.open("GET", "http://localhost:8080/Project1/getMsg.do?r_id=" + pid, true);
    
    xhttp.send();
}



function getOver() {
		
		
        
		
    let xhttp = new XMLHttpRequest();
    
    xhttp.onreadystatechange = function() {
        
        if(this.readyState == 4 && this.status == 200) {
            
            console.log(this.responseText);
            
            
            
            
                                 
            
            document.getElementById("awards").innerHTML = '$' + this.responseText;
            

            
        }
    }
    
    xhttp.open("GET", "http://localhost:8080/Project1/getOverFunds.do", true);
    
    xhttp.send();
}

function getSeshUser(){
    
    let xhttp = new XMLHttpRequest();

    xhttp.onreadystatechange = function() {

        if(this.readyState == 4 && this.status == 200) {

            console.log(this.responseText);
        }   
    }
    xhttp.open("GET", "http://localhost:8080/Project1/getCurr.do", true);
    
    xhttp.send();
}

function getReimbCur() {
		
    let pid = document.getElementById("reqcur").value;
    console.log(pid);
    
    let xhttp = new XMLHttpRequest();
    
    xhttp.onreadystatechange = function() {
        
        if(this.readyState == 4 && this.status == 200) {
            
            console.log(this.responseText);
            
            let reimbModel = JSON.parse(this.responseText);
            
            function parseJSONrequests(val) {              
                
                 let blocks = '-----------------------------------';
                console.log(val.length);
                for (let i = 0; i < val.length; i++){
                    
                    
                    blocks += 
                    `<br>Reimb ID: ${reimbModel[i].r_id} <br> 
                    User ID: ${reimbModel[i].u_id} <br>
                    Grading ID: ${reimbModel[i].g_id} <br>
                    Event ID: ${reimbModel[i].e_id} <br>
                    Date (weeks out): ${reimbModel[i].r_date} <br>
                    Time: ${reimbModel[i].r_time} <br>
                    Address: ${reimbModel[i].r_address}<br>
                    Cost: $${reimbModel[i].r_cost} <br>
                    Passing grade: ${reimbModel[i].cutoff}% <br>
                    Current User: ${reimbModel[i].curr_user} <br>
                    Description: ${reimbModel[i].r_desc} <br>
                    -----------------------------------
                    <br> `;
                }
                
                console.log(blocks);
                document.getElementById("showreimbcur").innerHTML = blocks;
            }
            parseJSONrequests(reimbModel);
            
            
        }
    }
    
    xhttp.open("GET", "http://localhost:8080/Project1/getCurr.do?u_id=" + pid, true);
    
    xhttp.send();
}


function getReimb() {
		
    let pid = document.getElementById("getreimb").value;
    console.log(pid);
    
    let xhttp = new XMLHttpRequest();
    
    xhttp.onreadystatechange = function() {
        
        if(this.readyState == 4 && this.status == 200) {
            
            console.log(this.responseText);
            
            let reimbModel = JSON.parse(this.responseText);
            
            let information = ` <h3>Reimbursement ID: ${reimbModel.r_id}</h3>
                                 <h3>User ID: ${reimbModel.u_id}</h3> 
                                 <h3>Grade ID: ${reimbModel.g_id}</h3>
                                 <h3>Event ID: ${reimbModel.e_id}</h3>
                                 <h3>Date (weeks out): ${reimbModel.r_date}</h3>
                                 <h3>Time (24 hr): ${reimbModel.r_time}</h3>
                                 <h3>Address: ${reimbModel.r_address}</h3>
                                 <h3>Cost: ${reimbModel.r_cost}</h3>
                                 <h3>Description: ${reimbModel.r_desc}</h3>
                                 <h3>Cutoff (%): ${reimbModel.cutoff}</h3>
                                 <h3>Intended user: ${reimbModel.curr_user}</h3>`
            
            document.getElementById("getreimbursement").innerHTML = information;
        }
    }
    
    xhttp.open("GET", "http://localhost:8080/Project1/getReimb.do?r_id=" + pid, true);
    
    xhttp.send();
}

function getUserName(us_id) {
		
    let u_id = us_id
    console.log(u_id);
    
    let xhttp = new XMLHttpRequest();
    
    xhttp.onreadystatechange = function() {
        
        if(this.readyState == 4 && this.status == 200) {
            
            console.log(this.responseText);
            
            let UserModel = JSON.parse(this.responseText);
            
            let information = ` <h3>User ID: ${UserModel.u_id}</h3>
                                 <h3>Department ID: ${UserModel.d_id}</h3> 
                                 <h3>First: ${UserModel.fname}</h3>
                                 <h3>Last: ${UserModel.lname}</h3>
                                 <h3>Reimbursement Available: ${UserModel.reimb_avail}</h3>
                                 <h3>Reimbursement Pending: ${UserModel.reimb_pend}</h3>
                                 <h3>Superior's User ID: ${UserModel.reports_to}</h3>
                                 <h3>Reimbursement Awarded: ${UserModel.reimb_award}</h3>`
                                 
            
                               

            return '5'
        }
    }
    
    xhttp.open("GET", "http://localhost:8080/Project1/getUser.do?u_id=" + u_id, true);
    
    xhttp.send();
}

function getUser() {
		
    let u_id = document.getElementById("uid").value;
    console.log(u_id);
    
    let xhttp = new XMLHttpRequest();
    
    xhttp.onreadystatechange = function() {
        
        if(this.readyState == 4 && this.status == 200) {
            
            console.log(this.responseText);
            
            let UserModel = JSON.parse(this.responseText);
            
            let information = ` <h3>User ID: ${UserModel.u_id}</h3>
                                 <h3>Department ID: ${UserModel.d_id}</h3> 
                                 <h3>First: ${UserModel.fname}</h3>
                                 <h3>Last: ${UserModel.lname}</h3>
                                 <h3>Reimbursement Available: ${UserModel.reimb_avail}</h3>
                                 <h3>Reimbursement Pending: ${UserModel.reimb_pend}</h3>
                                 <h3>Superior's User ID: ${UserModel.reports_to}</h3>
                                 <h3>Reimbursement Awarded: ${UserModel.reimb_award}</h3>`
                                 
            
                               

            document.getElementById("result").innerHTML = information;
        }
    }
    
    xhttp.open("GET", "http://localhost:8080/Project1/getUser.do?u_id=" + u_id, true);
    
    xhttp.send();
}

function incrementReimb() {
		
    let r_id = Number(document.getElementById("rid6").value);
    let u_id = Number(document.getElementById("myid6").value);
    
    
    let xhttp = new XMLHttpRequest();
    
    xhttp.onreadystatechange = function() {
        
        if(this.readyState == 4 && this.status == 200) {
            
            console.log(this.responseText);
            
            
            
            
            
            
        }
    }
    
    xhttp.open("GET", "http://localhost:8080/Project1/incrementReimb.do?r_id=" + r_id + "&u_id=" + u_id, true);
    
    xhttp.send();
}

function moveReimb() {

	
    let r_id = document.getElementById("r_id3").value;
    console.log(r_id3);
    let u_id = document.getElementById("u_id3").value;
    console.log(u_id3);
    
    
    
    let xhttp = new XMLHttpRequest();

    xhttp.onreadystatechange = function () {
        if(this.readyState == 4 && this.status == 200) {
            
			console.log(this.responseText);
            
        }
    }

    
    xhttp.open("POST", "http://localhost:8080/Project1/moveReimb.do", true);
    
    xhttp.setRequestHeader('X-Requested-With', 'XMLHttpRequest');
    xhttp.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
    
    
    xhttp.send("r_id="+r_id+"&u_id="+u_id);

}

function rejectReimb() {
		
    let r_id = Number(document.getElementById("r_id4").value);
    let u_id = Number(document.getElementById("u_id4").value);
    let message = document.getElementById("message4").value;
    
    console.log(r_id);
    
    
    let xhttp = new XMLHttpRequest();
    
    xhttp.onreadystatechange = function() {
        
        if(this.readyState == 4 && this.status == 200) {
            
            console.log(this.responseText);
            
            
            
            let s = this.responseText;
            let sp = s.split("[end of message]");

            // function doThing(){
            // for (var i = 0; i < sp.length; i++) {
                 
            //     document.getElementById("result").innerHTML
            // }
            document.getElementById("rejectid").innerHTML = 'Rejected reimbursement request ' + r_id;
        }
    }
    
    xhttp.open("GET", "http://localhost:8080/Project1/rejectReimb.do?r_id=" + r_id + "&u_id=" + u_id + "&message=" + message, true);
    
    xhttp.send();
}

function getUsers() {
		
		
		
    let xhttp = new XMLHttpRequest();
    
    xhttp.onreadystatechange = function() {
        
        if(this.readyState == 4 && this.status == 200) {
            
            console.log(this.responseText);
            
            let UserModel = JSON.parse(this.responseText);
            let res = this.responseText
            let information = ` <h3>User ID: ${UserModel.u_id}</h3>
                                 <h3>Department ID: ${UserModel.d_id}</h3> 
                                 <h3>First: ${UserModel.fname}</h3>
                                 <h3>Last: ${UserModel.lname}</h3>
                                 <h3>Reimbursement Available: ${UserModel.reimb_avail}</h3>
                                 <h3>Reimbursement Pending: ${UserModel.reimb_pend}</h3>
                                 <h3>Superior's User ID: ${UserModel.reports_to}</h3>
                                 <h3>Reimbursement Awarded: ${UserModel.reimb_award}</h3>`
                                 
                                function parseJSONrequests(val) {
                                    document.getElementById('getdunder').style.display = 'block';
                                    
                                    
                                    let blocks = '-----------------------------------';
                                    console.log(val.length);
                                    for (let i = 0; i < val.length; i++){
                                        
                                        
                                        blocks += `<br>User ID: ${val[i].u_id} <br> 
                                       
                                        First name: ${val[i].fname} <br>
                                        Last name: ${val[i].lname} <br>
                                         Department: ${getDept(val[i].d_id)} <br>
                                         Reimbursement available: ${val[i].reimb_avail} <br>
                                        Reimbursement pending: ${val[i].reimb_pend} <br>
                                        Reimbursement awarded: ${val[i].reimb_award}<br>
                                        Reports to: ${getReportsTo(val[i].reports_to)} <br>
                                        
                                        -----------------------------------
                                        <br> `;
                                    }
                                    
                                    console.log(blocks);
                                    document.getElementById("getdunder").innerHTML = blocks;
                                }
                                parseJSONrequests(UserModel);

          //document.getElementById("getdunder").innerHTML = this.responseText;
        }
    }
    
    xhttp.open("GET", "http://localhost:8080/Project1/showDunder.do", true);
    
    xhttp.send();
}

function showReimb() {
		
		
		
    let xhttp = new XMLHttpRequest();
    
    xhttp.onreadystatechange = function() {
        
        if(this.readyState == 4 && this.status == 200) {
            
            console.log(this.responseText);
            
            let reimbModel = JSON.parse(this.responseText);
            
            function parseJSONrequests(val) {
                
                
                
                let blocks = '-----------------------------------';
                console.log(val.length);
                for (let i = 0; i < val.length; i++){
                    
                    
                    blocks += `<br>Reimb ID: ${val[i].r_id} <br> 
                    User ID: ${val[i].u_id} <br>
                    Grading ID: ${val[i].g_id} <br>
                    Event ID: ${val[i].e_id} <br>
                    Date (weeks out): ${val[i].r_date} <br>
                    Time: ${val[i].r_time} <br>
                    Address: ${val[i].r_address}<br>
                    Cost: $${val[i].r_cost} <br>
                    Passing grade: ${val[i].cutoff}% <br>
                    Current User: ${val[i].curr_user} <br>
                    Description: ${val[i].r_desc} <br>
                    -----------------------------------
                    <br> `;
                }
                
                console.log(blocks);
                document.getElementById("getall").innerHTML = blocks;
            }parseJSONrequests(reimbModel);
        }
    }
    
    xhttp.open("GET", "http://localhost:8080/Project1/showReimb.do", true);
    
    xhttp.send();
}

function userReimbValue() {
		
    let pid = Number(document.getElementById('u_id2').value);
    console.log(pid);
    
    let xhttp = new XMLHttpRequest();
    
    xhttp.onreadystatechange = function() {
        
        if(this.readyState == 4 && this.status == 200) {
            
            console.log(this.responseText);
            
            let reimbModel = JSON.parse(this.responseText);
            
            function parseJSONrequests(val) {
                
                
                
                let blocks = '-----------------------------------';
                console.log(val.length);
                for (let i = 0; i < val.length; i++){
                    
                    
                    blocks += `<br>Reimb ID: ${val[i].r_id} <br> 
                    User ID: ${val[i].u_id} <br>
                    Grading ID: ${val[i].g_id} <br>
                    Event ID: ${val[i].e_id} <br>
                    Date (weeks out): ${val[i].r_date} <br>
                    Time: ${val[i].r_time} <br>
                    Address: ${val[i].r_address}<br>
                    Cost: $${val[i].r_cost} <br>
                    Passing grade: ${val[i].cutoff}% <br>
                    Current User: ${val[i].curr_user} <br>
                    Description: ${val[i].r_desc} <br>
                    -----------------------------------
                    <br> `;
                }
                
                console.log(blocks);
                document.getElementById("showuserreimb").innerHTML = blocks;
            }
            parseJSONrequests(reimbModel);
            
        }
    }
    
    xhttp.open("GET", "http://localhost:8080/Project1/userReimb.do?u_id=" + pid, true);
    
    xhttp.send();
}

function userReimb() {
		
    let pid = Number(document.getElementById("viewreimb").value);
    console.log(pid);
    
    let xhttp = new XMLHttpRequest();
    
    xhttp.onreadystatechange = function() {
        
        if(this.readyState == 4 && this.status == 200) {
            
            console.log(this.responseText);
            
            let reimbModel = JSON.parse(this.responseText);
            
            function parseJSONrequests(val) {
                document.getElementById('getdunder').style.display = 'block';
                
                
                let blocks = '-----------------------------------';
                console.log(val.length);
                for (let i = 0; i < val.length; i++){
                    
                    
                    blocks += `<br>Reimb ID: ${val[i].r_id} <br> 
                    User ID: ${val[i].u_id} <br>
                    Grading ID: ${val[i].g_id} <br>
                    Event ID: ${val[i].e_id} <br>
                    Date (weeks out): ${val[i].r_date} <br>
                    Time: ${val[i].r_time} <br>
                    Address: ${val[i].r_address}<br>
                    Cost: $${val[i].r_cost} <br>
                    Passing grade: ${val[i].cutoff}% <br>
                    Description: ${val[i].r_desc} <br>
                    -----------------------------------
                    <br> `;
                }
                
                console.log(blocks);
                document.getElementById("showuserreimb").innerHTML = blocks;
            }
            parseJSONrequests(reimbModel);
            
        }
    }
    
    xhttp.open("GET", "http://localhost:8080/Project1/userReimb.do?u_id=" + pid, true);
    
    xhttp.send();
}

function viewOAU() {
		
		
		
    let xhttp = new XMLHttpRequest();
    
    xhttp.onreadystatechange = function() {
        
        if(this.readyState == 4 && this.status == 200) {
            
            console.log(this.responseText);
            
            UserModel = JSON.parse(this.responseText);
            
            function parseJSONrequests(val) {
                document.getElementById('getdunder').style.display = 'block';
                
                
                let blocks = '-----------------------------------';
                console.log(val.length);
                for (let i = 0; i < val.length; i++){
                    
                    
                    blocks += `<br>User ID: ${val[i].u_id} <br> 
                   
                    First name: ${val[i].fname} <br>
                    Last name: ${val[i].lname} <br>
                     Department: ${getDept(val[i].d_id)} <br>
                     Reimbursement available: ${val[i].reimb_avail} <br>
                    Reimbursement pending: ${val[i].reimb_pend} <br>
                    Reimbursement awarded: ${val[i].reimb_award}<br>
                    Reports to: ${getReportsTo(val[i].reports_to)} <br>
                    
                    -----------------------------------
                    <br> `;
                }
                
                console.log(blocks);
                document.getElementById("limit").innerHTML = blocks;
            }
            parseJSONrequests(UserModel);
            

            
        }
    }
    
    xhttp.open("GET", "http://localhost:8080/Project1/usersOverFunds.do", true);
    
    xhttp.send();
}

