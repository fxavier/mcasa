"use client";
import Select from "react-select";

const PropertyDescription = () => {
  const catergoryOptions = [
    { value: "Apartments", label: "Apartmentos" },
    { value: "Bungalow", label: "Armazem" },
    { value: "Houses", label: "Moradia" },
    { value: "Loft", label: "Armazem" },
    { value: "Office", label: "Escritorio" },
    { value: "Townhome", label: "Terreno" },
    { value: "Villa", label: "Casa" },
  ];
  const listedIn = [
    { value: "All Listing", label: "All Listing" },
    { value: "Active", label: "Active" },
    { value: "Sold", label: "Sold" },
    { value: "Processing", label: "Processing" },
  ];
  const PropertyStatus = [
    { value: "All Cities", label: "All Cities" },
    { value: "Pending", label: "Pending" },
    { value: "Processing", label: "Processing" },
    { value: "Published", label: "Published" },
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
    <form className="form-style1">
      <div className="row">
        <div className="col-sm-12">
          <div className="mb20">
            <label className="heading-color ff-heading fw600 mb10">Titulo</label>
            <input
              type="text"
              className="form-control"
              placeholder="Your Name"
            />
          </div>
        </div>
        {/* End .col-12 */}

        <div className="col-sm-12">
          <div className="mb20">
            <label className="heading-color ff-heading fw600 mb10">
              Descrição
            </label>
            <textarea
              cols={30}
              rows={5}
              placeholder="There are many variations of passages."
              defaultValue={""}
            />
          </div>
        </div>
        {/* End .col-6 */}

        <div className="col-sm-6 col-xl-4">
          <div className="mb20">
            <label className="heading-color ff-heading fw600 mb10">
              Selecione a categoria
            </label>
            <div className="location-area">
              <Select
                defaultValue={[catergoryOptions[1]]}
                name="colors"
                options={catergoryOptions}
                styles={customStyles}
                className="select-custom pl-0"
                classNamePrefix="select"
                required
                isMulti
              />
            </div>
          </div>
        </div>
        {/* End .col-6 */}

        <div className="col-sm-6 col-xl-4">
          <div className="mb20">
            <label className="heading-color ff-heading fw600 mb10">
              Listed in
            </label>
            <div className="location-area">
              <Select
                defaultValue={[listedIn[1]]}
                name="colors"
                options={listedIn}
                styles={customStyles}
                className="select-custom pl-0"
                classNamePrefix="select"
                required
                isMulti
              />
            </div>
          </div>
        </div>
        {/* End .col-6 */}

        <div className="col-sm-6 col-xl-4">
          <div className="mb20">
            <label className="heading-color ff-heading fw600 mb10">
              Estado da propriedade
            </label>
            <div className="location-area">
              <Select
                defaultValue={[PropertyStatus[1]]}
                name="colors"
                options={PropertyStatus}
                styles={customStyles}
                className="select-custom pl-0"
                classNamePrefix="select"
                required
                isMulti
              />
            </div>
          </div>
        </div>
        {/* End .col-6 */}

        <div className="col-sm-6 col-xl-4">
          <div className="mb30">
            <label className="heading-color ff-heading fw600 mb10">
              Preço
            </label>
            <input
              type="text"
              className="form-control"
              placeholder="Your Name"
            />
          </div>
        </div>
        {/* End .col-6 */}

        <div className="col-sm-6 col-xl-4">
          <div className="mb30">
            <label className="heading-color ff-heading fw600 mb10">
              Taxas anuais
            </label>
            <input
              type="text"
              className="form-control"
              placeholder="Seu Name"
            />
          </div>
        </div>
        {/* End .col-6 */}

        <div className="col-sm-6 col-xl-4">
          <div className="mb30">
            <label className="heading-color ff-heading fw600 mb10">
              Depois do rotulo de preco
            </label>
            <input
              type="text"
              className="form-control"
              placeholder="Seu Name"
            />
          </div>
        </div>
        {/* End .col-6 */}
      </div>
    </form>
  );
};

export default PropertyDescription;
