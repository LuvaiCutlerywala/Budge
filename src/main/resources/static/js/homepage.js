function displayBudgetManagementArea(){
    let budgetManagementArea = document.getElementById("budget-management");
    if(budgetManagementArea.style.visibility === "hidden"){
        budgetManagementArea.style.visibility = "visible";
    } else {
        budgetManagementArea.style.visibility = "hidden";
    }
}

function addBudget(){
    let prompt = document.getElementById("action-prompt");
    if(postBudget()){
        prompt.innerHTML = "Your budget was successfully added.";
    } else {
        prompt.innerHTML = "There was a fault in adding your budget.";
    }
}

function removeBudget(){
    let prompt = document.getElementById("action-prompt");
    if(deleteBudget()){
        prompt.innerHTML = "Your budget was successfully removed.";
    } else {
        prompt.innerHTML = "There was a fault in removing your budget.";
    }
}

function viewBudgets(){
    let prompt = document.getElementById("action-prompt");
    let budgetDisplay = document.getElementById("budgets");

    let request = new XMLHttpRequest();
    request.open("GET", "http://localhost:8080/api/view-budgets");
    request.send(null);

    //response keeps returning as 
    if(request.response !== null && request.response !== ""){
        prompt.innerHTML = "Check the console";
        budgetDisplay.innerHTML = request.response;
        console.log(request.response);
    } else {
        prompt.innerHTML = "There was a problem fetching your budgets";
    }
}

function postBudget(){
    //Get the request obj and values for the budget title and amounts.
    let request = new XMLHttpRequest();
    let params = new URLSearchParams();
    let title = document.getElementById("budget-title").value;
    let amount = document.getElementById("budget-amount").value;

    //Load request with URL and send along with params.
    request.open("POST", "http://localhost:8080/api/add-budget")
    request.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
    params.append("title", title);
    params.append("amount", amount);
    request.send(params);

    if(request.ok){
        return true;
    }
    
    return false;
}

function deleteBudget(){
    //Get the request obj and value for budget title.
    let request = new XMLHttpRequest();
    let title = document.getElementById("budget-title").value;
    let params = new URLSearchParams();
    
    //Load request with URL and send along with params.
    request.open("DELETE", "http://localhost:8080/api/remove-budget");
    params.append("title", title);
    request.send(params);

    if(request.ok){
        return true;
    }

    return false;
}

/*
function getBudgets(){
    //Get the request obj.
    let request = new XMLHttpRequest();

    //Load request with URL and send.
    request.open("GET", "http://localhost:8080/api/view-budgets");
    request.send(null);

    return request;
}
*/
