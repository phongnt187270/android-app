<?php

namespace App;

use Illuminate\Database\Eloquent\Model;

class VaccinationInfo extends Model
{
    //
    public $timestamps = false;
    protected $fillable = [
        'vaccination_info_id',
        'vaccination_injection_1',
        'vaccination_injection_2'
    ];
    protected $primaryKey = 'vaccination_info_id';
    protected $foreignKey_1 = 'vaccination_injection_1';
    protected $foreignKey_2 = 'vaccination_injection_2';
    protected $table = 'vaccination_info';
    public $incrementing = false;
}
