package com.scurrae.chris.quickpix;

/**
 * Created by chris on 3/21/16.
 */
public class Images {
    int _id;
    int _image;

    // Empty constructor
    public Images(){

    }
    // Constructor with id and image as parameters
    public Images(int id, int image){
        this._id = id;
        this._image = image;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public int get_image() {
        return _image;
    }

    public void set_image(int _image) {
        this._image = _image;
    }
}
