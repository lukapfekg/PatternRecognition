# PatternRecognition
Project has been done after only one week of Pattern recognition class attendance at Faculty of Electrical Engineering.
Professor had very interesting introduction of pattern recognition based on probablity rather than A.I.
After only one lession I had an idea where i would make a simple program that will classify user hand writting of number one and two.  

Programm doesn't have any automatisation. First stage of program is the training part. User is required to manually write 1 or 2 and after that manually classify them.
After 5-10 reptitions of that classification user is required to set parameters of linear function that divides group of points representing ones(green) and twos(red).
Following the completion of previous task, user then proceeds to the window that has the function of pattern recognition. User hand writes the number on a white panel, and program automatically displays the cassified number.

Classification is statistically implemented. Lets say that we want to have two dimensions for classification. First one is that lenght of ones is often greather than width of ones, where as for twos
that logic does not apply as twos have more or less same width as length. Second dimension is ratio of pixels in the bottom third of the nuber and whole number. Twos gave bigger ratio than ones.
These two dimension we can present as 'x' and 'y' cordinate lines, and after initialising a couple of numbers we can set a line, or in this case a function, that can obviously devide two numbers.
