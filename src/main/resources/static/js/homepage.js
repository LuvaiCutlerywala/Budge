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

}

function removeBudget(){

}

function viewBudgets(){

}