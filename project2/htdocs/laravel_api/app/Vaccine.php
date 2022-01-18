<?php

namespace App;

use Illuminate\Database\Eloquent\Model;

class Vaccine extends Model
{
    //
    public $timestamps = false;
    protected $fillable = [
        'vaccine_id',
        'manufacturer',
        'dose_number',
        'injected_location',
        'injected_date',
        'commodity_number'
    ];
    protected $primaryKey = 'vaccine_id';
    public $incrementing = false;
    protected $table = 'vaccine';
}
