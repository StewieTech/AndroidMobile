# AskLolaLingo

## Project Outline

### POC
- Add Lola Personality to readme
- add ApiKey to readme in secrets

### MVP (LinkedIn Post)
- Add two models 
  - One Voice where you respond in French and they correct you then respond
  - One French to convo where they respond in english and french
- They should also show the french and english captions below before they talk
- If users come from Linkedin it will automatically have LinkedinFree5

### eventually I need to understand below
``` java
override fun <T : ViewModel?> create(modelClass: Class<T>): T {

Explanation:
This function overrides the create() method from ViewModelProvider.Factory.
<T : ViewModel?>: This specifies that T must be a type of ViewModel.
modelClass: Class<T>: This is the class type of the ViewModel that we want to create.
This method's job is to determine whether modelClass matches ChatViewModel and return an instance of it if true.
Analogy: Imagine you're at a factory, and depending on what kind of toy you request (e.g., modelClass could be "car" or "robot"), the factory will produce the corresponding toy (in this case, a ChatViewModel).

```