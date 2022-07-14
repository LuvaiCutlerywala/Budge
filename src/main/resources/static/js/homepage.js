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

    actionPrompt.innerHTML = "Your budget is being updated";

    request.open("POST", "http://192.168.50.154:8080/api/add-budget", true);
    request.onload = function (){
        if(request.ok){
            updatePrompt([actionPrompt], ["Your budgets were updated successfully"]);
        } else {
            updatePrompt([actionPrompt], ["There was an issue in updating your budgets"]);
        }
    }

    params.append("title", title.value);
    params.append("amount", amount.value);

    request.send(params);
}

function removeBudget(){

}

function viewBudgets(){

}