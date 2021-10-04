import speech_recognition as sr
import wolframalpha
import pyttsx3

engine = pyttsx3.init()
r=sr.Recognizer()
app_id = "<Get app id from wolframaplha website>"
client = wolframalpha.Client(app_id)
over=0
print('am Listening...')
engine.say('I am Listening')
engine.runAndWait()

while over<1:
    with sr.Microphone() as source:
        r.adjust_for_ambient_noise(source)
        audio=r.listen(source)
        try:
            voice_data=r.recognize_google(audio)
            if voice_data=='who created you':
                answer='I am a creation of <Your name>'
            elif voice_data=='bye':
                answer='Bye'
                over=1
            else:
                res = client.query(voice_data)
                answer = next(res.results).text
            print(answer)
            engine.say(answer)
            engine.runAndWait()
        except (sr.UnknownValueError,AttributeError,StopIteration):
            print("Sorry can't get you..")
            engine.say("Sorry can't get you..")
            engine.runAndWait()
