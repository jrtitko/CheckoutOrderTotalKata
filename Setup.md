# Setup

## Bash

Pull the git repository for this project.  

    git clone git@github.com:jrtitko/CheckoutOrderTotalKata.git

To use the commit history as a learning tool, you can set up the following aliases to navigate the history more easily.
You can set up aliases by typing them in your terminal window or adding them to your .bashrc file to navigate the history more easily.  
If you add the aliases to your .bashrc file, remember to source it or open a new terminal window.  Aliases are only good
in the terminal window you set them up in.

    alias prev='git checkout HEAD~'
    alias next='git checkout $(git rev-list --topo-order HEAD.."solution" | tail -1)'

Before you can use the prev/next aliases, you will need to set up the solution branch locally using the following command from inside the project folder you cloned.

    git checkout solution

You will need to go back to the master branch to start this course.

    git checkout master

To more easily read the log file, I suggest setting up the following alias as well.

    alias log='git log --oneline --decorate --graph --all'

At this point, you can use the aliases defined above (prev & next) to manuver through the commits in the solution.  

**NOTE:** After using the commands prev & next, Git will put you in a detached state, but you can still maneuver through the logs.  To reset the project, type 'git checkout master'

**NOTE:** If you use the terminal window in IntelliJ, you will have to click in one of the files to get the refresh after moving through the commits.  

## IntelliJ

In IntelliJ, you may want to familiarize yourself with a couple of features in IntelliJ that we will be using to make coding the tests faster.  You can find these features [here](https://github.com/jrtitko/CheckoutOrderTotalKata/blob/master/IntelliJ%20IDEA%20Commands%20%26%20Shortcuts.md)

## Spock

If you are unfamiliar with Spock, you can check out the basics [here](https://github.com/jrtitko/CheckoutOrderTotalKata/blob/master/Spock.md)
