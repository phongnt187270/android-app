<?php

namespace App;

use Illuminate\Database\Eloquent\Model;


class User extends Model
{
    //
    public $timestamps = false;
    protected $fillable = [
        'user_id', 
        'phonenumber', 
        'password', 
        'name', 
        'dob', 
        'division', 
        'role', 
        'vaccination_info_id'
    ];
    protected $primaryKey = 'user_id';
    protected $foreignKey = 'vaccination_info_id';
    protected $table = 'user';
    public $incrementing = false;
}
