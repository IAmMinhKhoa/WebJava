const form = document.getElementById("chat-form");
const input = document.getElementById("chat-input");
const messages = document.getElementById("chat-messages");
const apiKey = "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";

form.addEventListener("submit", async (e) => {
  e.preventDefault();
  const message = input.value;
  input.value = "";
  messages.innerHTML += `<div class="message user-message"><img src="./assets/images/news/user.png" alt="user icon"> <span>${message}</span></div>`;

  // Use axios library to make a POST request to the OpenAI API
  const response = await axios.post(
    
    
    'https://api.openai.com/v1/chat/completions',
    {
		messages:[{role:'user', content:message}],
		model:'gpt-3.5-turbo-1106',
		temperature: 0.2,
		max_tokens:900,
		top_p: 1,
     	frequency_penalty: 0.2,
      presence_penalty: 0.2,
	},
	{
		headers:{
			'Content-Type': "application/json",
			Authorization:`Bearer ${apiKey}`,
			
		},
	}
    
  );
 
  const chatbotResponse = response.data.choices[0].message.content;
console.log(chatbotResponse);

  messages.innerHTML += `<div class="message bot-message"><img src="./assets/images/news/chatbot.png" alt="bot icon"> <span>${chatbotResponse}</span></div>`;
});

/*"https://api.openai.com/v1/chat/completions",
    {
      prompt: message,
      //model: "text-davinci-003",
      model:"gpt-3.5-turbo",
     // model: "gpt-3.5-turbo-1106",
      temperature: 0.1,
      max_tokens: 100,
      top_p: 1,
      frequency_penalty: 0.2,
      presence_penalty: 0.2,
    },
    {
      headers: {
        "Content-Type": "application/json",
        Authorization: `Bearer ${apiKey}`,
      },
    }*/