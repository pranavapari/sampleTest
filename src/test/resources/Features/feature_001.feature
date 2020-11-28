Feature: Create end to end flow from choosing compose functionality and send a email with an attachment

Scenario: Verify compose functionality (valid user details)
Given user launch browser and enter URL as "https://www.google.com" addres
When user enter emailaddress as "createdaccout255@gmail.com" and click on Next
And user enter Password as "Access@1234*" and click on Next
#And click on sent mail tab and get sent mails count
And user click on compose mail
And user enter tomailid as "testc839@gmail.com" and Subject as "My Resume"
And user enter his Message in text body
"""
Hi 
Please find my attachments
Thanks & Regards
Pranava.
"""
And user attached resume
And user click on send button
Then user go to sent items and verify
And click on sign out