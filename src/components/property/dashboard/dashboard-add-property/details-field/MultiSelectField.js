"use client";
import React from "react";
import Select from "react-select";

const options = {
  floorNo: ["1º", "2º", "3º", "4º"],
  energyClass: ["Todos os anúncios", "Ativo", "Vendido", "Processando"],
  energyIndex: ["Todas as cidades", "Pendente", "Processando", "Publicado"]
};

const customStyles = {
  option: (styles, { isFocused, isSelected, isHovered }) => {
    return {
      ...styles,
      backgroundColor: isSelected
        ? "#eb6753"
        : isHovered
        ? "#eb675312"
        : isFocused
        ? "#eb675312"
        : undefined,
    };
  },
};

const MultiSelectField = () => {
  const fieldTitles = ["Andares", "Classe Energética", "Índice de Energia em kWh/m2a"];
  return (
    <>
      {Object.keys(options).map((key, index) => (
        <div className="col-sm-6 col-xl-4" key={index}>
          <div className="mb20">
            <label className="heading-color ff-heading fw600 mb10">
              {fieldTitles[index]}
            </label>
            <div className="location-area">
              <Select
                styles={customStyles}
                className="select-custom pl-0"
                classNamePrefix="select"
                required
                isMulti
                options={options[key].map((item) => ({
                  value: item,
                  label: item,
                }))}
              />
            </div>
          </div>
        </div>
      ))}
    </>
  );
};

export default MultiSelectField;
