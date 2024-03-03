"use client";
import Select from "react-select";

const SelectDropdown = () => {
  const catOptions = [
    { value: "Apartments", label: "Apartmentos" },
    { value: "Bungalow", label: "Moradias" },
    { value: "Houses", label: "Casas" },
    { value: "Loft", label: "Lojas" },
    { value: "Office", label: "Escritorios" },
    { value: "Townhome", label: "Armazem" },
    { value: "Villa", label: "Terreno" },
  ];

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

  return (
    <>
      <Select
        defaultValue={[catOptions[0]]}
        name="colors"
        options={catOptions}
        styles={customStyles}
        className="text-start select-borderless"
        classNamePrefix="select"
        required
        isSearchable={false}
      />
    </>
  );
};

export default SelectDropdown;
