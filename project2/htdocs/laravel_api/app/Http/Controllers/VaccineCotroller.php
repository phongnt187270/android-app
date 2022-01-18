<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use App\Vaccine;
use App\Http\Resources\VaccineResource;
use App\Http\Resources\VaccineCollection;

class VaccineCotroller extends Controller
{
    /**
     * Display a listing of the resource.
     *
     * @return \Illuminate\Http\Response
     */
    public function index()
    {
        //
        return Vaccine::all();
    }

    /**
     * Show the form for creating a new resource.
     *
     * @return \Illuminate\Http\Response
     */
    public function create()
    {
        //
    }

    /**
     * Store a newly created resource in storage.
     *
     * @param  \Illuminate\Http\Request  $request
     * @return \Illuminate\Http\Response
     */
    public function store(Request $request)
    {
        //
        $request->validate([
            'vaccine_id' => 'required',
            'manufacturer' => 'required',
            'dose_number' => 'required',
            'injected_location' => 'required',
            'injected_date' => 'required',
            'commodity_number' => 'required'
        ]);

        $vaccine = Vaccine::create($request->all());
        return new VaccineResource($vaccine);
        
    }

    /**
     * Display the specified resource.
     *
     * @param  int  $id
     * @return \Illuminate\Http\Response
     */
    public function show($vaccine)
    {
        //
        return Vaccine::find($vaccine);
    }

    /**
     * Show the form for editing the specified resource.
     *
     * @param  int  $id
     * @return \Illuminate\Http\Response
     */
    public function edit($id)
    {
        //
    }

    /**
     * Update the specified resource in storage.
     *
     * @param  \Illuminate\Http\Request  $request
     * @param  int  $id
     * @return \Illuminate\Http\Response
     */
    public function update(Request $request, Vaccine $vaccine)
    {
        //
        $vaccine->update($request->all());
        return new VaccineResource($vaccine);
    }

    /**
     * Remove the specified resource from storage.
     *
     * @param  int  $id
     * @return \Illuminate\Http\Response
     */
    public function destroy(Vaccine $vaccine)
    {
        //
        $vaccine->delete();
    }
}
