import React from "react";

const MenuWidget = () => {
  const menuSections = [
    {
      title: "Pesquisas populares",
      links: [
        { label: "Apartmento para Arrendar", href: "#" },
        { label: "Apartamento Baixo a Alto", href: "#" },
        { label: "Escritórios para comprar", href: "#" },
        { label: "Escritórios para arrendar", href: "#" },
      ],
    },
    {
      title: "Links rápidos",
      links: [
        { label: "Termos de uso", href: "#" },
        { label: "Politicas de Privacidade", href: "#" },
        { label: "Planos", href: "#" },
        { label: "Nossos Serviços", href: "#" },
        { label: "Contacto para suporte", href: "#" },
        { label: "Careiras", href: "#" },
        { label: "FAQs", href: "#" },
      ],
    },
    {
      title: "Discubra",
      links: [
        { label: "Maputo", href: "#" },
        { label: "Matola", href: "#" },
        { label: "Beira", href: "#" },
        { label: "Nampula", href: "#" },
      ],
    },
  ];

  return (
    <>
      {menuSections.map((section, index) => (
        <div className="col-auto" key={index}>
          <div className="link-style1 mb-3">
            <h6 className="text-white mb25">{section.title}</h6>
            <ul className="ps-0">
              {section.links.map((link, linkIndex) => (
                <li key={linkIndex}>
                  <a href={link.href}>{link.label}</a>
                </li>
              ))}
            </ul>
          </div>
        </div>
      ))}
    </>
  );
};

export default MenuWidget;
