package br.ufsc.cursofs.AulaSpringBoot.services;

import java.util.List;
import java.util.NoSuchElementException;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ufsc.cursofs.AulaSpringBoot.entities.Categoria;
import br.ufsc.cursofs.AulaSpringBoot.entities.Endereco;
import br.ufsc.cursofs.AulaSpringBoot.entities.Produto;
import br.ufsc.cursofs.AulaSpringBoot.repositories.CategoriaRepository;
import br.ufsc.cursofs.AulaSpringBoot.repositories.ProdutoRepository;

@Service
public class ProdutoService {
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private CategoriaRepository categoriaRepository; 

	//Servico para associar e desassociar um endereço ao produto
	public Produto addCategoria(Long idProduto, Long idCategoria) {
		Produto produto = produtoRepository.findById(idProduto).get();
		Categoria categoria = categoriaRepository.findById(idCategoria).get();
		
		produto.getCategorias().add(categoria);
		produtoRepository.save(produto);
		return produto;
	}
	
	//Servico para Remover  um endereço do produto
		public Produto removeCategoria(Long idProduto, Long idCategoria) {
			Produto produto = produtoRepository.findById(idProduto).get();
			Categoria categoria = categoriaRepository.findById(idCategoria).get();
			
			produto.getCategorias().remove(categoria);
			produtoRepository.save(produto);
			return produto;
		}
		
	
	public Produto update(Long id, Produto produto) {
		Produto produtoEntity = produtoRepository.getReferenceById(id);
		
		produtoEntity.setDescricao(produto.getDescricao());
		produtoEntity.setPreco(produto.getPreco());
		produtoEntity.setQuantidade(produto.getQuantidade());
		
		
		return produtoRepository.save(produtoEntity);		
	}
	
	
	public void deleteById(Long id) {
		//try {
			produtoRepository.deleteById(id);
		//}catch (RuntimeException e) {
		//	e.printStackTrace();
		//}
		
	}
	
	
	public Produto save(Produto produto) {
		return produtoRepository.save(produto);
	}
	
	public List<Produto> findAll(){
		return produtoRepository.findAll();
	}

	public Produto findById(Long id) {		
		try {
			return produtoRepository.findById(id).get();
		} catch(NoSuchElementException e) {
			throw new EntityNotFoundException("EntityNotFoundException Produto id: " + id);
		}
	}
	
	
	
}
