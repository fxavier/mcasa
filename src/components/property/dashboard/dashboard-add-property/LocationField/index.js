import React from "react";
import SelectMulitField from "./SelectMulitField";
import Map from "./Map";

const LocationField = () => {
  return (
    <form className="form-style1">
      <div className="row">
        <div className="col-sm-12">
          <div className="mb20">
            <label className="heading-color ff-heading fw600 mb10">
              Endereço
            </label>
            <input
              type="text"
              className="form-control"
              placeholder="Seu Name"
            />
          </div>
        </div>
        {/* End col-12 */}

        <SelectMulitField />

        <div className="col-sm-6 col-xl-4">
          <div className="mb20">
            <label className="heading-color ff-heading fw600 mb10">Caixa Postal</label>
            <input type="text" className="form-control" />
          </div>
        </div>
        {/* End col-4 */}

        <div className="col-sm-6 col-xl-4">
          <div className="mb20">
            <label className="heading-color ff-heading fw600 mb10">
              Perto de
            </label>
            <input
              type="text"
              className="form-control"
              placeholder="Neighborhood"
            />
          </div>
        </div>
        {/* End col-4 */}

        <div className="col-sm-12">
          <div className="mb20 mt30">
            <label className="heading-color ff-heading fw600 mb30">
            Coloque o pin do anúncio no mapa
            </label>
            <Map />
          </div>
        </div>
        {/* End col-12 */}
      </div>
      {/* End .row */}

      <div className="row">
        <div className="col-sm-6 col-xl-4">
          <div className="mb30">
            <label className="heading-color ff-heading fw600 mb10">
              Latitude
            </label>
            <input type="text" className="form-control" />
          </div>
        </div>
        {/* End .col-sm-6 */}

        <div className="col-sm-6 col-xl-4">
          <div className="mb30">
            <label className="heading-color ff-heading fw600 mb10">
              Longitude
            </label>
            <input type="text" className="form-control" />
          </div>
        </div>
      </div>
      {/* End .row */}
    </form>
  );
};

export default LocationField;
