Max Mraz
Root Coding Problem

In this project, I wrote a simple console app that will take some user input. As per the project guidelines,
you can enter a filename a text file for the application to read and generate a report on the drivers it describes,
or you can manually enter driver and trips following the same format.

I chose to write this project in java, as it's the language I have the most experience writing tests with, and
test-driven design brings me inner peace. I chose to model drivers and trips as objects. Since there would be
multiple instances of drivers and multiple instances of trips all following the same model, objects would
work just dandy for this. A trip can keep track of its own distance and duration and speed as instance variables,
then drivers would hold their names and a collection of their trip objects.

I did give some thought to using a framework like Spring and JPA to have repositories for this data, but I decided
that all that was more than this project really required, and elected to keep it very pared down and simple.
Plain old java objects would do the trick.

After I wrote tests and modeled all this data, I designed a user interface. The main method being a loop that
asks for user input would be about as complex an implementation as I'd need, and that sends the user's input
to a processor object to make in into data to populate my model. This processor object also stores all the
drivers input into the system, so that it can organize them by how far they've driven whenever a new driver
shows up.

And important part of my process was test-driven design. By writing tests for functionality before I wrote the
functionality, I knew  was designing code that would meet my goals, and I had the security to mess around with
things as much as I wanted and be able to run my unit tests confident if I broke everything, I'd know immediately.

