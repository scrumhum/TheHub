const API="http://127.0.0.1:8081";

async function sd(server,data){
	let options={
		method:'POST',
		body:JSON.stringify(data)
	}
	//console.log(options); //see http header before request is sent
	return await fetch(server,options).then(response=>{
		let isJson=response.headers.get('content-type')?.includes('application/json');
		let tError=(isJson?response.json():null);
		if(!response.ok){
			let error=(tError && tError.message)||response.status;
			return Promise.reject(error);
		}
		else{
			return response.text().then(reply=>{
				return JSON.parse(reply);
			});
		}
	}).catch(e=>console.log("Error: "+e));
}
function cp(target,nohide){
	if(target=="_profile_") {
		let mydata = {pf:true}
		let jsonObj=sd(API,mydata).then(r=>{
			if(r) updateDataElement(r);
		});
		displayTarget();
	}
	if(target == "_events_") {
		let mydata = {ev:true}
		let jsonObj=sd(API,mydata).then(r=>{
			if(r) updateDataElement(r);
		});
		displayTarget();
	}
	if(target=="_calendar_") {
		let mydata = {cd:true}
		let jsonObj=sd(API,mydata).then(r=>{
			if(r) updateDataElement(r);
		});
		displayTarget();
	}
	else displayTarget();
	function displayTarget(){
		if(!document.getElementById(target)) return;
		if(!nohide) document.querySelectorAll(".dynamic").forEach(e=>{e.setAttributeNS(null,"style","display:none;visibility:hidden;")});
		document.getElementById(target).setAttributeNS(null,"style","display:flex;visibility:visible;");
	}
}
function ca() {
	let targetFirst = document.getElementById("fname");
	let targetUser = document.getElementById("signin_uname");
	let targetLast = document.getElementById("lname");
	let targetPass = document.getElementById("signin_password");
	let targetEmail = document.getElementById("email");
		if(!targetFirst.value){
			console.log("Must have a first name.");
			return;
		}
		else if(!targetLast.value){
			console.log("Must have a last name.");
			return;
		}
		else if(!targetUser.value){
			console.log("Must have a username.");
			return;
		}
		else if(targetFirst.value.length > 20){
			console.log("First name is too long");
			return;
		}
		else if(targetLast.value.length > 20){
			console.log("Last name is too long");
			return;
		}
		else if(/[^A-Za-z\'\-4]+/g.test(targetFirst.value)){
			console.log("First name is too weird");
			return;
		}
		else if(/[^A-Za-z\'\-4]+/g.test(targetLast.value)){
			console.log("Last name is too weird");
			return;
		}
		else if(targetUser.value.length > 30){
			console.log("Too long");
			return;
		}
		else if(/[^A-Za-z0-9\_\-\.]+/g.test(targetUser.value)){
			console.log("Username is too weird");
			return;
		}
		else if(targetPass.value.length > 512){
			console.log("Too long");
			return;
		}
		else if(targetPass.value.length < 9){
			console.log("Too short");
			return;
		}
		else if(/[^\!-\~]+/g.test(targetPass.value)){
			console.log("Too weird");
			return;
		}
		else if(document.getElementById("confirm_password").value!==targetPass.value){
			console.log("No");
			return;
		}
		else if(/[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?/.test(targetEmail.value)==false){
			console.log("Invalid Email Adress");
			return;
		}
		let mydata={};
		mydata.fn=targetFirst.value;
		mydata.ln=targetLast.value;
		mydata.em=targetEmail.value;
		mydata.un=targetUser.value;
		mydata.pw=targetPass.value;
		mydata.ca=true;
		let jsonObj=sd(API,mydata).then(r=>{
			if(r.matchedCount > 0) {
				console.log("An account with this email already exists.");
			}
			else{
				if(r) updateDataElement(r);
				cp("_profile_");
			}
		});
		
}
function login() {
	let targetUser = document.getElementById("uname").value;
	let targetPass = document.getElementById("password").value;
	if(!targetUser){
		console.log("Must have a username.");
		return;
	}
	else if(!targetPass) {
		console.log("Must have a password");
		return;
	}
	else if(targetUser.length > 30){
		console.log("Too long");
		return;
	}
	else if(/[^A-Za-z0-9\_\-\.]+/g.test(targetUser)){
		console.log("Username is too weird");
		return;
	}
	else if(targetPass.length > 512){
		console.log("Too long");
		return;
	}
	else if(targetPass.length < 9){
		console.log("Too short");
		return;
	}
	else if(/[^\!-\~]+/g.test(targetPass)){
		console.log("Too weird");
		return;
	}
	let mydata={};
	mydata.un = targetUser;
	mydata.pw = targetPass;
	mydata.ln = true;
	let jsonObj=sd(API,mydata).then(r=>{
			if(r) updateDataElement(r);
/*			let dataContainerElement = document.getElementById("_data_");
			for(let key in r){
				dataContainerElement.setAttribute("data-"+key,r[key]);
			}
 			dataContainerElement.setAttribute("data-uname",r.uname);
			dataContainerElement.setAttribute("data-fname",r.fname);
			dataContainerElement.setAttribute("data-lname",r.lname);
			dataContainerElement.setAttribute("data-email",r.email); */
			cp("_profile_");
		});
}
function updateDataElement(serverResponse){
	let dataContainerElement = document.getElementById("_data_");
	for(let key in serverResponse){
		dataContainerElement.setAttribute("data-"+key,serverResponse[key]);
	}
}
function search() {
	let targetSearch = document.getElementById('search').value;
	if(!targetSearch) return;
	targetSearch = DOMPurify.sanitize(targetSearch);
	targetSearch = targetSearch.replace(/url\(.*\)/g,"");
	let mydata={};
	mydata.ts = targetSearch;
	mydata.sh = true;
	let jsonObj=sd(API,mydata).then(r=>{ // MAYBE NOT?? CHECK LATER
		if(r) updateDataElement(r);
	});
}
function createEvent() {
	let eventTitle = document.getElementById("etitle");
	let eventDate = document.getElementById("edate");
	let eventTime = document.getElementById("etime");
	let eventRepeat = document.getElementById("erepeat");
	let eventScope = document.getElementById("escope");
	let eventPeople = document.getElementById("epoeple");
	let eventLocation = document.getElementById("elocation");
	let eventDescription = document.getElementById("edescription");
	if (maliciousInput(eventTitle)) console.log("Invalid Title");
	else if (/0-9//g.test(eventDate) ) console.log("Invalid Date");
}
const callback = (mutationList, observer) => {
	for(const mutation of mutationList) {
		//console.log("mutation",mutation);
		//console.log("type:",typeof mutation.target.dataset,"value:",mutation.target.dataset);
		for(let key in mutation.target.dataset){
			//console.log("key",key);
			let val=mutation.target.dataset[key];
			let classSelector=".cn_"+key+"_";
			let t=document.querySelectorAll(classSelector);
			if(t){
				t.forEach(e=>{
					e.innerHTML="";
					e.insertAdjacentHTML("afterbegin",val);
				})
			}

		}	
	}
};
function maliciousInput(input) {
	if(/[^A-Za-z0-9\_\-\.\ \!\?\@\#\$\%\&\(\)]+/g.test(input)) {
		return true;
	}
}

const observer = new MutationObserver(callback);
observer.observe(document.getElementById("_data_"),{attributes: true});
//observer.disconnect();