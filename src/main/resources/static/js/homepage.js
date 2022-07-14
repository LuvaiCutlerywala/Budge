function displayBudgetManagementArea(){
    let budgetManagementArea = document.getElementById("budget-management");
    if(budgetManagementArea.style.visibility === "hidden"){
        budgetManagementArea.style.visibility = "visible";
    } else {
        budgetManagementArea.style.visibility = "hidden";
    }
}

function updatePrompt(elements, messages){
    for(let i = 0; i <= elements.length; ++i){
        elements[i].innerHTML = messages[i];
    }
}

function addBudget(){
    let request = new XMLHttpRequest();
    let params = new URLSearchParams();
    let title = document.getElementById("budget-title");
    let amount = document.getElementById("budget-amount");
    let actionPrompt = document.getElementById("action-prompt");

    updatePrompt([actionPrompt], ["Your budgets are being added"]);

    request.open("POST", "http://192.168.50.154:8080/api/add-budget", true);
    request.onload = function (){
        if(request.ok){
            updatePrompt([actionPrompt], ["Your budget was added successfully"]);
        } else {
            updatePrompt([actionPrompt], ["There was an issue in adding your budget"]);
        }
    }

    params.append("title", title.value);
    params.append("amount", amount.value);

    request.send(params);
}

function removeBudget(){
    let request = new XMLHttpRequest();
    let params = new URLSearchParams();
    let title = document.getElementById("budget-title");
    let actionPrompt = document.getElementById("action-prompt");

    updatePrompt([actionPrompt], ["Your budget is being removed"]);

    request.open("DELETE", "http://192.168.50.154:8080/api/remove-budget", true);
    request.onload = function (){
        if(request.ok){
            updatePrompt([actionPrompt], ["Your budget was removed successfully"]);
        } else {
            updatePrompt([actionPrompt], ["There was an issue in removing your budget"]);
        }
    }

    params.append("title", title.value);

    request.send(params);
}

function viewBudgets(){
    let request = new XMLHttpRequest();
    let budgets = document.getElementById("budgets");
    let actionPrompt = document.getElementById("action-prompt");

    updatePrompt([actionPrompt], ["Your budgets are being fetched"]);

    request.open("GET", "http://192.168.50.154:8080/api/view-budgets", true);
    request.onload = function (){
        if(request.ok) {
            updatePrompt([budgets, actionPrompt], [request.response, "Here are your budgets"]);
        } else {
            updatePrompt([actionPrompt], ["There was an issue in fetching your budgets"]);
        }
    }

    request.send(null);
}