document.getElementById("voteForm").addEventListener("submit", function(event) {
    event.preventDefault();
    
    let candidate = document.querySelector('input[name="candidate"]:checked');
    
    if (!candidate) {
        alert("Please select a candidate!");
        return;
    }

    fetch("/VotingSystem/vote", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify({ candidate: candidate.value })
    })
    .then(response => response.json())
    .then(data => {
        document.getElementById("message").innerText = data.message;
    })
    .catch(error => console.error("Error:", error));
});
