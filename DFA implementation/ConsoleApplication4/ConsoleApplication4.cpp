#include <iostream>
#include <conio.h>
using namespace std;

int isLetter(char ch) {
    if (ch >= 'A' && ch <= 'Z' || ch >= 'a' && ch <= 'z')
        return 1;
    else
        return 0;
}
int isDigit(char ch)
{
    if (ch >= '0' && ch <= '9')
        return 1;
    else
        return 0;
}
int accept(int state)
{
    if (state == 3)
        return 1;
    else
        return 0;
}
int error(int state)
{
    if (state == 0)
        return 1;
    else
        return 0;
}

int Trans(int state, char ch)
{
    if (state == 1 && isLetter(ch))
        return 2;
    else if (state == 2)
    {
        if (isLetter(ch) || isDigit(ch))
            return 2;
        else
            return 3;

    }
    return 0;
}

int advance(int state, char ch) {
    if (state == 0)
        return 0;
    else if (state == 1) {
        if (isLetter(ch))
            return 1;
        else
            return 0;
    }
    if (state == 2) {
        if (isLetter(ch) || isDigit(ch)) {
            return 1;
        }
        else
            return 0;

        }
        if (state == 3){
            return 0;
    }
    return 0;
    }

    int main() {
        int state = 1;
        char ch =_getche();
        while (!accept(state) && !error(state)) {
            int newState = Trans(state, ch);
            if (advance(state, ch))
                ch =_getche();
            state = newState;

        }
        if (accept(state))
            cout << "Accept";
        else
            cout << "Reject";

        return 0;
    }