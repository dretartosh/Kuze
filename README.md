# KUZE Chatbot Engine
A java-based chatbot designed to help users track job applications by generating personalized
questions, statements and excitement responses.
Kuse uses placeholder replacement (progName, username) to create dynamice, human-like interactions

# FEATURES
  > Personalized chatbot responses
  > Dynamic placeholder replacement
  > Multiple response categories
      - Questions
      - Statements
      - Excitements
  > Sentinel keyword detection for exiting conversation
  > OOD
  > Fully documented with Javadoc

# HOW IT WORKS
Kuze loads three response banks at startup:
  > questions[]
  > statements[]
  > excitements[]

Each response contains placeholders:
  > progName -> replaced with chatbot name
  > username -> replaced with user's name

	> Example:
		promptBank: "Hi, I am progName. How are you today, userName?"
		Display: "Hi, I am KUZE. How are you today, TYE?"

# SENTINEL EXIT KEYWORD
Users can exit the conversation by entering "SENTINEL". Kuze detects this and
ends the sessions gracefully.

# PROJECT STRUCTURE
src/
 └── Kuze.java

# How to Run
Clone the repository
Open the project in your Java IDE
Compile and run your main application (e.g., JobApplication.java)
Interact with Kuze through the console


# Example Interaction
     Hello, I am a Chatbot, ready to help to track your Job Applications.
     Enter your name: Andre

     Kuze: Hi, I am KUZE. How are you today, TYE?
     Tye: I am good!

     Kuze: Fantastic energy, TYE! KUZE is ready for whatever you want to do next.


# Future Enhancements
  -> Load responses from a database
  -> Add conversation memory
  -> Add GUI interface
  -> Add more response categories
  -> Integrate with job-tracking APIs

# Author
Tye Tosh
Java Developer & IT Specialist
Queens, NY

#License
This project is open‑source under the MIT License.
