import React from "react";

const Category = () => {
  const categories = ["Moradias", "Apartmentos", "Escritórios", "Armazens", "Terrenos"];

  return (
    <div className="sidebar-widget mb30">
      <h6 className="widget-title">Categorias</h6>
      <div className="category-list d-flex flex-column mt20">
        {categories.map((category, index) => (
          <a href="#" key={index}>
            {category}
          </a>
        ))}
      </div>
    </div>
  );
};

export default Category;
