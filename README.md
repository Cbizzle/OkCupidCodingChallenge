# OkCupid Android Challenge

This app allows you to explore OkCupid users who you can potentially like. You can like many users, but your top 6 
liked users will be displayed in descending order by match percent another tab called "Match %."

Uses: MVVM architecture, android live data, glide for image loading, dagger2 for dependency injection.

## Installation

I use lombok so the lombok plug-in is needed. Also the SDK may need to be updated. Android Studio 3 was used.

## Architecture:
This app uses the MVVM architecture.
The users and okcupid data are the model. 
The viewmodel exposes this information using live data. 
There are also listeners and callbacks that allow the views to be altered, and their states
to determine the states of other views. (Liking a user triggers the like listener, which edits the live data that
is being observed on).
The views consist of the main activity, the tablayout and viewpager, the viewpager houses the two fragments
which display recyclerviews for both the Special Blend and Match Percent, as well as the recycler view items 
which display the user data view. This user view data is data bound to the user data.

Dependency injection is also included for easy swapping of componenets such as layout managers and adapters.

## Testing:
This includes some unit tests and espresso tests.

![alt tag](https://i.imgur.com/LQ7JQJt.png "Starting screen")
![alt tag](https://i.imgur.com/qeRBTD1.png "Liking a user")
![alt tag](https://i.imgur.com/M1PZXfH.png "Liked user in the top matches.")
