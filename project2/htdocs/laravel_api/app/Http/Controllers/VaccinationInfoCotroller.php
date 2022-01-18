<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use App\VaccinationInfo;
use App\Http\Resources\VaccinationInfoCardResource;
use App\Http\Resources\VaccinationInfoCardCollection;

class VaccinationInfoCotroller extends Controller
{
    /**
     * Display a listing of the resource.
     *
     * @return \Illuminate\Http\Response
     */
    public function index()
    {
        //
        return VaccinationInfo::all();
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
            'vaccination_info_id' => 'required',

            
        ]);

        $vaccination_card = VaccinationInfo::create($request->all());
        return new VaccinationInfoCardResource($vaccination_card);
    }

    /**
     * Display the specified resource.
     *
     * @param  int  $id
     * @return \Illuminate\Http\Response
     */
    public function show( $vaccination_card)
    {
        //
        return VaccinationInfo::find($vaccination_card);
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
    public function update(Request $request, VaccinationInfo $vaccination_card)
    {
        //
        $vaccination_card->update($request->all());

        return new VaccinationInfoCardResource($vaccination_card);
    }

    /**
     * Remove the specified resource from storage.
     *
     * @param  int  $id
     * @return \Illuminate\Http\Response
     */
    public function destroy(VaccinationInfo $vaccination_card)
    {
        //
        $vaccination_card->delete();
    }
}
