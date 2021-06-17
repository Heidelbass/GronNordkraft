package com.example.test2;

public class SliderItem {

    private int image;

    SliderItem(int image) { this.image = image; } // We save a image in form of the type int. It is saved in a felt on the class 'this'. (Det bliver gemt i et felt på klassen (this))

    public int getImage() { return image; } //This gets the image and returns it
}

//  Image slider using View Pager 2:  https://www.youtube.com/watch?v=iA9iqygq11Q