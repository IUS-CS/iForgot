# iForgot Organizer Architecture


## Home Page (Calendar)

* This page will have a calendar on it.
* The calendar will call getEvents() from the backend and will load up the calendar with events.
* Calendar will auto-update when a new event is added.
* Home Page will have links to all of the other webpages.

## About Us Page

* This page will tell the reader who we are and what we planned to accomplish with this product.
* Won't need any backend support.
* Contact information.
* Links to Home Page and Login Page.

## Login Page

* This page will have a Facebook Login button.
* Links to About Us page will be included.
* Login will call back end to authenticate the user and load the settings.

## Model of Website

![Architecture](../architecturediagram.png)
