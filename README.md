# Pokedex
![123123123](https://user-images.githubusercontent.com/8842528/216180563-2383450d-e7ac-40f0-8b9a-fa794c491c83.gif)
![234234234](https://user-images.githubusercontent.com/8842528/216180732-1225c3ad-4079-493f-add4-b91ee093b510.gif)

## What is Pokedex?
Pokedex is a modern but simple Android app that has the following features:
- Displays a list of all Pokemons
- You can click on a pokemon to see more info on that particular pokemon.
- You can search for a particular pokemon in the searchbar.

The app is built with scalability in mind, using the latest Android developmen practices. It is built using MVVM architecture, and makes use of Modularization.

## App architecture
![architecture](/img/UI.png)

The app is designed with 4 layers:
- UI layer: Here you have your compose views
- Presentation Layer: Here you have your ViewModels, which are responsible for presenting your data, and handling user input and delegating them to Domain layer & Listen for data
- Domain Layer: Here lies all the Repositories you need for to access your data. They handle traffic from network & storing in local Database. The app also makes use of UseCases to handle user input & Get data.
- Data layer: Here you have your different Datasources. Each Datasource is responsible for accessing data from a different source, such as local database, remote sources, datastore, etc.


## App modules
![modules](/img/p.png)

The app makes use of modules to split different components into its own module. Why modules? To lower buildtimes, only build the parts you need after making changes to them, to de-couple parts of the app. This makes the app more readable, scalable and testable.



## Techstack
- :white_check_mark: Kotlin
- :white_check_mark: Compose and Navigation component
- :white_check_mark: Coroutines for asynchronous tasks 
- :white_check_mark: MVVM with jetpack Viewmodel
- :white_check_mark: Clean architecture with usecase's and repository pattern
- :white_check_mark: Hilt for dependecy injection
- :white_check_mark: Room for local database
- :white_check_mark: Retrofit for fetching remote data from PokeApi
- :white_check_mark: Moshi for JSON operations
- :white_check_mark: Coil for image loading
- :white_check_mark: Timber for logging
- :black_square_button: Use of UI, Integration and Unit tests

## TODO
- :black_square_button: Modularize by feature
- :black_square_button: Add newsfeed
- :black_square_button: Add settings
- :black_square_button: Add Favourites
- :black_square_button: Migrate to Paging 3

# License

    MIT License

    Copyright 2019 AliAmid93

    Permission is hereby granted, free of charge, to any person obtaining a 
    copy of this software and associated documentation files (the "Software"),
    to deal in the Software without restriction, including without limitation 
    the rights to use, copy, modify, merge, publish, distribute, sublicense, 
    and/or sell copies of the Software, and to permit persons to whom the 
    Software is furnished to do so, subject to the following conditions:

    The above copyright notice and this permission notice shall be included 
    in all copies or substantial portions of the Software.

    THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS 
    OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
    FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
    AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY,
    WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR
    IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
